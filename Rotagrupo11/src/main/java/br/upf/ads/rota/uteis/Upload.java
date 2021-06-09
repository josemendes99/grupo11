/*
 * Upload.java
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.upf.ads.rota.uteis;

import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
import net.iamvegan.multipartrequest.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

/**
 *
 * @author Jaqson Dalbosco

 * O FORMULARIO HTML DEVE TER O ATRIBUTO
    enctype="multipart/form-data"

 * IMPORTS NECESSARIOS NA SERVLET
    import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
    import net.iamvegan.multipartrequest.MultipartFile;

 * PARA TRATAR REQUEST COM MULTIPART, COLOCAR NA SERVLET ANTES DE USAR O request 
    request = new HttpServletMultipartRequest(
                  request,
                  HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
                  HttpServletMultipartRequest.SAVE_TO_TMPDIR,
                  HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
                  HttpServletMultipartRequest.DEFAULT_ENCODING);

 * PARA COPIAR UM ARQUIVO PELA SERVLET
    Upload.copiarArquivo((HttpServletMultipartRequest)request, "campo_html", "C:/upload", "arquivo.gif");

 * OUTROS EXEMPLOS DE USO
    out.print(
    "<br>Nome: "+Upload.getNomeArquivo((HttpServletMultipartRequest)request, "campo_html")+
    "<br>Tipo: "+Upload.getTipoArquivo((HttpServletMultipartRequest)request, "campo_html")+
    "<br>Tamanho: "+Upload.getTamanhoArquivo((HttpServletMultipartRequest)request, "campo_html"));

 */
public class Upload {

   public Upload() {
   }

   /**
    * M�todo que pegar os dados dos arquivos recebidos por upload.
    * Usar getDadosDosArquivos(request)
    * @param request
    * @return
    */
   public static String getDadosDosArquivos(HttpServletMultipartRequest request) {
      String retorno = "";
      try {
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         for (Enumeration e = ((HttpServletMultipartRequest) request).getFileParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(name);
            retorno += "[" + multiFile.getName() + ", " +
                    multiFile.getSize() + "bytes, " +
                    multiFile.getContentType() + "] ";
         }
      } catch (Exception e) {
         return "";
      }

      return retorno;
   }

   /**
    * M�todo que retorna o tipo de arquivo informado em um campo de upload. 
    * Usar getTipoArquivo(request, "nome_campo_html")
    * @param request
    * @param campo
    * @return
    */
   public static String getTipoArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getContentType();
   }

   /**
    * M�todo que retorna o tamanho de um arquivo de upload em bytes.
    * Usar getTamanhoArquivo(request, "nome_campo_html")
    * @param request
    * @param campo
    * @return
    */
   public static long getTamanhoArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getSize();
   }

   /**
    * M�todo que retorna o nome do arquivo informado pelo cliente no browser.
    * Usar getNomeArquivo(request, "nome_campo_html")
    * @param request
    * @param campo
    * @return
    */
   public static String getNomeArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getName();
   }

   /**
    * M�todo para copiar um arquivo de upload para uma pasta no servidor renomeando o arquivo.
    * Usar copiarArquivo(request, "nome_campo_html", "c:/uploads", "novoNome.gif")
    * @param request
    * @param campo_html
    * @param dirDestino
    * @param nomeArquivodestino
    * @return
    */
   public static boolean copiarArquivo(HttpServletMultipartRequest request,
           String campo_html,
           String dirDestino,
           String nomeArquivodestino) {
      boolean copiou = false;
      try {
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo_html);
         InputStream in = multiFile.getInputStream();
         copiou = false;
         if (in != null) {
            BufferedInputStream input = new BufferedInputStream(in);
            FileOutputStream file = new FileOutputStream(new File(dirDestino, nomeArquivodestino));
            // Now copy contents of file 
            int read;
            byte[] buffer = new byte[4096];
            while ((read = input.read(buffer)) != -1) {
               file.write(buffer, 0, read);
            }
            file.close();
            input.close();
            copiou = true;
         } else {
            return false;
         }
      } catch (Exception e) {
         return false;
      }

      return copiou;
   }

   /**
    * M�todo para copiar um arquivo de upload para uma pasta no servidor.
    * Usar copiarArquivo(request, "c:/uploads")
    * @param request
    * @param dirDestino
    * @return
    */
   public static boolean copiarArquivos(HttpServletMultipartRequest request,
           String dirDestino) {
      boolean copiou = false;
      try {
         //out.println(((HttpServletMultipartRequest)request).toHtmlString());
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         for (Enumeration e = ((HttpServletMultipartRequest) request).getFileParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(name);
            InputStream in = multiFile.getInputStream();
            copiou = false;
            if (in != null) {
               BufferedInputStream input = new BufferedInputStream(in);
               FileOutputStream file = new FileOutputStream(new File(dirDestino, multiFile.getName()));
               // Now copy contents of file 
               int read;
               byte[] buffer = new byte[4096];
               while ((read = input.read(buffer)) != -1) {
                  file.write(buffer, 0, read);
               }
               file.close();
               input.close();
               copiou = true;
            } else {
               return false;
            }
         }
      } catch (Exception e) {
         return false;
      }

      return copiou;
   }
   
   
   public static byte[] getBytesArquivo(HttpServletMultipartRequest request, String campo_html) {
      try {
         MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo_html);
         InputStream in = multiFile.getInputStream();
         return in.readAllBytes();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }   
   
   
}
