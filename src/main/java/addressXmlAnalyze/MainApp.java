package addressXmlAnalyze;

import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File("src/main/resources/address.xml")); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Element data = document.getRootElement();
        System.out.println(data.getName());
        List<Address> addressList = new ArrayList<>(10000);

        for (Iterator dataIter = data.elementIterator(); dataIter.hasNext();) {
            Element row = (Element) dataIter.next();
            Iterator rowIter = row.elementIterator();
            Element id = (Element) rowIter.next();
            Element code = (Element) rowIter.next();
            Element type = (Element) rowIter.next();
            Element provinceCode = (Element) rowIter.next();
            Element cityCode = (Element) rowIter.next();
            Element countyCode = (Element) rowIter.next();
            Element province = (Element) rowIter.next();
            Element city = (Element) rowIter.next();
            Element county = (Element) rowIter.next();
            Address address = new Address();
            address.setId(id.getStringValue());
            address.setCode(code.getStringValue());
            address.setType(type.getStringValue());
            address.setProvinceCode(provinceCode.getStringValue());
            address.setCityCode(cityCode.getStringValue());
            address.setCountyCode(countyCode.getStringValue());
            address.setProvince(province.getStringValue());
            address.setCity(city.getStringValue());
            address.setCounty(county.getStringValue());
            addressList.add(address);
        }
        //Map<String,Object> jsonMap = new HashMap();
        List<Map> provinceList = new ArrayList<>();
        List<Map> cityList = new ArrayList<>();
        List<Map> areaList = new ArrayList<>();
        for(int i=0;i<addressList.size();i++){
            Address current = addressList.get(i);

            //Map<String,Object> provinceMap = new HashMap<>();
            //Map<String,Object> cityMap = new HashMap<>();
            //Map<String,Object> areaMap = new HashMap<>();
            //如果是省级
            if(current.getType().equals("1")){
                cityList = new ArrayList<>();
                Map<String,Object> provinceMap = new LinkedHashMap<>();
                provinceMap.put("name",current.getProvince());
                provinceMap.put("code",current.getCode());
                provinceMap.put("city",cityList);
                provinceList.add(provinceMap);
            }
            //如果是市级
            if(current.getType().equals("2")){
                areaList = new ArrayList<>();
                Map<String,Object> cityMap = new LinkedHashMap<>();
                cityMap.put("name",current.getCity());
                cityMap.put("code",current.getCode());
                cityMap.put("area",areaList);
                cityList.add(cityMap);
            }
            if(current.getType().equals("3")){
                Map<String,Object> areaMap = new LinkedHashMap<>();
                areaMap.put("name",current.getCounty());
                areaMap.put("code",current.getCode());
                areaList.add(areaMap);
            }
        }
        //jsonMap.put("address",provinceList);
        String str = JSON.toJSONString(provinceList);

        System.out.println(str);
        System.out.println(str.length());
    }
}
