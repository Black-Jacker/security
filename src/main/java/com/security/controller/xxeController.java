package com.security.controller;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Iterator;

@Controller
public class xxeController {

    @GetMapping(value="/docx2txt")
    public String getDocx(Model model){
        model.addAttribute("title","docx to txt--XXE攻击");
        model.addAttribute("action","/doc2txt");
        return "docx2txt";
    }

    @GetMapping("/xml")
    public String getXml(Model model){
        model.addAttribute("title","xml to txt--XXE攻击");
        model.addAttribute("action","/xml");
        return "docx2txt";
    }
    @PostMapping(value="/docx2txt")
    @ResponseBody
    public String postDocx(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()){
            try {
                XWPFDocument document = new XWPFDocument(file.getInputStream());
                XWPFParagraph para;
                String rt="";
                Iterator<XWPFParagraph> iterator = document.getParagraphsIterator();
                while (iterator.hasNext()){
                    para = iterator.next();
                    rt += para.getText();
                }
                return rt;
            }catch (IOException e){
                e.printStackTrace();
                return "上传失败"+e.getMessage();
            }
        }else {
            return "文件为空";
        }
    }

    @PostMapping(value="/xml")
    @ResponseBody
    public String postXml(@RequestParam("file") MultipartFile file){
        try{
            SAXReader reader = new SAXReader();

            return reader.read(file.getInputStream()).asXML();
        }catch (DocumentException | IOException | NullPointerException e){
            e.printStackTrace();
            return "上传失败"+e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败"+e.getMessage();
        }
    }

}
