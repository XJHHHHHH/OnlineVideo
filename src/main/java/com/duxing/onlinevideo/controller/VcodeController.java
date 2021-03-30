package com.duxing.onlinevideo.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.duxing.onlinevideo.dto.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class VcodeController {


    @RequestMapping("/checkVcode")
    @ResponseBody
    public ResponseResult checkVcode(String vcode, HttpSession session) {
        ResponseResult result = new ResponseResult(-1, "vcode invalid");
        String sVcode = (String) session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(vcode) || StrUtil.isEmpty(sVcode)) {
            return result;
        }
        if (!sVcode.equals(vcode)) {
            return result;
        }
        result.setRcode(1);
        result.setMessage("ok");
        return result;
    }

    char[] vcodeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a','b','c','d','e','f','g'};

    // 相应验证码，二进制图片
    // http协议设置响应的类型
    // src=/vcode 获得图片验证码
    @RequestMapping("/vcode")
    public void vcode(HttpServletResponse resp, HttpServletRequest request) {


        // 设置生成图片的属性
        BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);

        Graphics2D gd = bufferedImage.createGraphics();

        gd.setColor(Color.WHITE);

        gd.drawRect(0, 0, 80, 30);

        Font font = new Font("宋体", Font.BOLD, 25);

        gd.setFont(font);

        // 保存验证码
        StringBuilder builder = new StringBuilder();
        // 生成随机验证码
        for (int i = 0; i < 4; i++) {
            String rdStr = String.valueOf(vcodeSequence[RandomUtil.randomInt(17)]);

            builder.append(rdStr);
            // rgb
            gd.setColor(Color.WHITE);

            // 80 4 15
            // 15 25
            // 30 25
            // 45 25
            // 60 25
            gd.drawString(rdStr, (i + 1) * 15, 25);
        }

        // 验证码保存到session
        HttpSession session = request.getSession(true);
        session.setAttribute("session_vcode", builder.toString());

        // 设置HTTP协议响应头，图片类型
        // https://tool.oschina.net/commons http协议规定数据类型
        resp.setContentType("image/jpeg");
        // 不使用缓存
//        Cache-Control:no-cache
//        Pragma:no-cache
//        Expires：-1
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");


        try {
            ServletOutputStream ous = resp.getOutputStream();

            ImageIO.write(bufferedImage, "jpeg", ous);

            ous.flush();
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
