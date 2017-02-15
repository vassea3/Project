package com.mycompany.controllers;

import com.mycompany.model.HomeSlider;
import com.mycompany.service.intf.HomeSliderServiceIntf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeSliderController {

    @Autowired(required = true)
    @Qualifier(value = "homeSlideService")
    HomeSliderServiceIntf homeSliderService;
    static HomeSlider homSlid = new HomeSlider();

    @RequestMapping("/cmsEditSlide/{id}")
    public String showCmsEditSlideshow(@PathVariable("id") int id, Model model) {
        homSlid = null;
        homSlid = homeSliderService.findById(id);
        return "redirect:/cmsHomeSlider";
    }

    @RequestMapping("/cmsHomeSlider")
    public String showSlideshow(Model model) {
        model.addAttribute("homeSlide", homSlid);
        return "cmsHomeSlider";
    }

    @RequestMapping(value = "/updateSlide", method = RequestMethod.POST)
    public String updateSlide(@RequestParam("id") int id, @RequestParam("titlul") String titlul,
            @RequestParam("descrierea") String descrierea, @RequestParam("reducerea") String reducerea,
            @RequestParam("file") MultipartFile file) throws IOException {

        HomeSlider hS = new HomeSlider();
        hS.setId(id);
        hS.setTitlul(titlul);
        hS.setDescrierea(descrierea);
        hS.setImgName(file.getOriginalFilename());
        hS.setReducerea(reducerea);
        hS.setImgBytes(readByte(file));
        this.homeSliderService.update(hS);
        System.out.println(hS);
        return "redirect:/cmsHomeSlider?success=true";
    }

    public byte[] readByte(MultipartFile file) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        HttpServletRequest request = null;
        String uploadsDir = "/resources/slideImages/";
        String imgPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(uploadsDir);
        File file1 = new File(imgPath + file.getOriginalFilename());
        // FileOutputStream fos = new FileOutputStream(file1);
        byte[] bytes = null;
        try {
            fis = (FileInputStream) file.getInputStream();
            bytes = new byte[fis.available()];
            fis.read(bytes);
            //  fos.write(bytes);
            fis.close();
            //  fos.close();
        } catch (Exception e) {

        }
        return bytes;
    }
}
