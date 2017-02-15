///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.controllers;
//
//import com.mycompany.model.Images;
//import com.mycompany.service.intf.ImagesServiceIntf;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import com.mycompany.dao.intf.ImagesIntf;
//
///**
// *
// * @author Taniusha
// */
//@Controller
//public class ImagesController {
//
//    @Autowired(required = true)
//    @Qualifier(value = "imageService")
//    private ImagesServiceIntf imageServiceIntf;
//
//    @RequestMapping(value = "/saveImages.do", method = RequestMethod.POST)
//    public String saveImage(@RequestParam CommonsMultipartFile[] imgFile) throws Exception {
//
//        if (imgFile != null && imgFile.length > 0) {
//            for (CommonsMultipartFile aFile : imgFile) {
//
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//
//                Images image = new Images();
//                image.setImgName(aFile.getOriginalFilename());
//                image.setImgFile(aFile.getBytes());
//                imageServiceIntf.save(image);
//                Comunication.imageList.add(image);
//            }
//        }
//
//        return "cmsProductManagement";
//    }
//}
