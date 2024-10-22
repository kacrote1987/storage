//package com.wision.util;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class ExcelController {
//
//    @GetMapping("/xdx/export")
//    public void fun(HttpServletResponse response) {
//        String[] header=new String[]{"姓名","年纪"};
//        String[] keys=new String[]{"name","age"};
//        List<Map<String, Object>> content=new ArrayList<>();
//        Map<String, Object> map1=new HashMap<>();
//        map1.put("name","小道仙");
//        map1.put("age","23");
//        content.add(map1);
//        Map<String, Object> map2=new HashMap<>();
//        map2.put("name","小道仙97");
//        map2.put("age","97");
//        content.add(map2);
//        try {
//            ExcelUtils.exportExcel(response,header,keys,content,"文件表","sheet1");
//        }catch (Exception e){
//            System.out.println("导出失败!");
//        }
//    }
//
//    @PostMapping("/xdx/import")
//    public void fun(@RequestBody MultipartFile file) throws Exception {
//        String[] keys = new String[]{"dept", "name","score","dwsl","bgsh","jsl","hgl"};
//        List<Map<String, Object>> list=ExcelUtils.importExcel(file,keys);
//        for(Map<String,Object> map:list){
//            System.out.print(map.get("dept")+","+map.get("name")+","+map.get("score")+","+map.get("dwsl")+","+map.get("bgsh")+","+map.get("jsl")+","+map.get("hgl"));
////            for(String key:map.keySet()){
////                System.out.print(key+":"+map.get(key)+",");
////            }
//            System.out.println();
//        }
//    }
//
//
//}