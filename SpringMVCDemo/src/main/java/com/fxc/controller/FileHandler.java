package com.fxc.controller;

import lombok.val;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 */
@Controller
@RequestMapping("/file")
public class FileHandler {
    @PostMapping(value = "/upload")
    public String upload(@RequestParam(value = "img") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8;");
        if(file.getSize()>0){
            //  获取保存上传文件的file路径
            String path = request.getServletContext().getRealPath("file");
            //  获取上传文件名
            String name = file.getOriginalFilename();
            File newFile = new File(path, name);
            try {
                file.transferTo(newFile);
                //  保存上传之后的文件路径
                //  这里有个问题，如果文件名包含中文的话，则请求参数会出现乱码，导致显示请求404
                request.setAttribute("path", "/file/"+name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request){
        List<String> files = new ArrayList<>();
        for(MultipartFile img : imgs){
            if(img.getSize()>0){
                //  获取保存上传文件的file路径
                String path = request.getServletContext().getRealPath("file");
                //  获取上传文件名
                String name = img.getOriginalFilename();
                File file = new File(path, name);
                try {
                    img.transferTo(file);
                    //  保存上传之后的文件路径
                    files.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files", files);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        if(name!=null){
            name += ".jpg";
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path, name);
            OutputStream outputStream = null;
            if(file.exists()){
                response.setContentType("application/forc-download");
                response.setHeader("Content-Disposition", "attachment;filename="+name);
                try {
                    outputStream = response.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(outputStream!=null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
