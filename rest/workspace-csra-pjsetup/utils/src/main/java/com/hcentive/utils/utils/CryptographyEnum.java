package com.hcentive.utils.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;


public enum CryptographyEnum {
	
	 TRIPLEDES {
     	
     	@Override
         public String encrypt(String text,String key) throws Exception{
             
     		byte[] seed_key = new String(key).getBytes();
    		SecretKeySpec keySpec = new SecretKeySpec(seed_key, "TripleDES");
    		Cipher nCipher = Cipher.getInstance("TripleDES");
    		nCipher.init(Cipher.ENCRYPT_MODE, keySpec);
    		byte[] cipherbyte = nCipher.doFinal(text.getBytes());
    		return new String(Base64.encodeBase64URLSafeString(cipherbyte));    	
         	
         }	     	
         @Override
        public String decrypt(String encryptedText,String key) throws Exception{
             
        	byte[] seed_key = new String(key).getBytes();
     		SecretKeySpec keySpec = new SecretKeySpec(seed_key, "TripleDES");
     		Cipher nCipher = Cipher.getInstance("TripleDES");
     		nCipher.init(Cipher.DECRYPT_MODE, keySpec);
     		byte[] encData = Base64.decodeBase64(encryptedText.getBytes());
     		byte[] decryptedtxt = nCipher.doFinal(encData);
     		return new String(decryptedtxt);
         }		            
     },
     PBEWITHMD5ANDTRIPLEDES {      	
    	// jasypt supported Alogrithms
     	//DIGEST ALGORITHMS:   [MD2, MD5, SHA, SHA-256, SHA-384, SHA-512]
     	//PBE ALGORITHMS:      [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
      	@Override
          public String encrypt(String text,String key) throws Exception{
              
      		 StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	         encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
	         encryptor.setPassword(key);
	         return encryptor.encrypt(text);   	
          	
          }	     	
          @Override
         public String decrypt(String encryptedText,String key) throws Exception{              
         	 StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
 	         encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
 	         encryptor.setPassword(key);
 	         return encryptor.decrypt(encryptedText);
          }		            
      },
     AES {
     	
     	@Override
         public String encrypt(String propValue,String key) throws Exception{
             
         	return "AES";
         }	     	
         @Override
         public String decrypt(String propValue,String key) throws Exception{
             return "AES";
         }         
     },
     TEXT {
      	
      	@Override
          public String encrypt(String propValue,String key) throws Exception{
              
          	return propValue;
          }	     	
          @Override
          public String decrypt(String propValue,String key) throws Exception{
              return propValue;
          }         
      };

     public abstract String encrypt(String propValue,String key) throws Exception;
     public abstract String decrypt(String propValue,String key) throws Exception;

     public static CryptographyEnum getCryptoType(String v) {
         for (CryptographyEnum c: CryptographyEnum.values()) {
             if (c.name().equals(v)) {            	
                 return c;
             }
         }
         throw new IllegalArgumentException(v);
     }
     
}
