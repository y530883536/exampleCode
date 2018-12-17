package cryptology;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;  
  
import javax.crypto.Mac;  
import javax.crypto.spec.SecretKeySpec;  
  
import org.apache.commons.codec.binary.Base64;  

public class HMAC_SHA1 {  
  
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";  

    public static String genHMAC(String data, String key) throws Exception{
        byte[] result = null;  
        try {  
            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称    
            SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);  
            //生成一个指定 Mac 算法 的 Mac 对象    
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);  
            //用给定密钥初始化 Mac 对象    
            mac.init(signinKey);  
            //完成 Mac 操作     
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = Base64.encodeBase64(rawHmac);
  
        } catch (NoSuchAlgorithmException e) {  
            System.err.println(e.getMessage());  
        } catch (InvalidKeyException e) {  
            System.err.println(e.getMessage());  
        }  
        if (null != result) {  
            return new String(result);  
        } else {  
            return null;  
        }  
    }  
    /** 
     * 测试 
     * @param args 
     */  
    public static void main(String[] args) throws Exception{
        String data = "GETcvm.tencentcloudapi.com/?Action=DescribeInstances&InstanceIds.0=ins-09dx96dg&Limit=20&Nonce=11886&Offset=0&Region=ap-guangzhou&SecretId=AKIDz8krbsJ5yKBZQpn74WFkmLPx3EXAMPLE&Timestamp=1465185768&Version=2017-03-12";
        String key = "Gu5t9xGARNpq86cd98joQYCN3EXAMPLE";
        String genHMAC = genHMAC(data, key);
        System.out.println(genHMAC.length());
        System.out.println(genHMAC);


    }  
} 