/**
 * Pruebas unitarias para el algoritmo de Huffman.
 * @Author: Carlos Delgado
 * @Version: 1
 * @Date: 03/JUL/2023
 */
package project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestHuffman {

  private ClassLoader classLoader = getClass().getClassLoader();

  private VerifyTree verifyTree;

  @BeforeAll
  public void createVerifyTree(){
    verifyTree = new VerifyTree();
  }

  private String loadFile(String fileName){
    try{
      Path filePath = Path.of(classLoader.getResource(fileName).getFile());
      return Files.readString(filePath, StandardCharsets.UTF_8);
    }
    catch(IOException e){
      return null;
    }

  }

  @Test
  public void testFile1() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text = loadFile("ejemplo1.in");
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    assertTrue(verifyTree.verify(tree));
    assertEquals(text, decoded);
  }

  @Test
  public void testFile2() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text = loadFile("ejemplo2.in");
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    assertTrue(verifyTree.verify(tree));
    assertEquals(text, decoded);
  }

  @Test
  public void testFile3() {
    //Setup
    HuffmanCoding coding = new HuffmanCoding();
    String text = loadFile("ejemplo3.in");
    HuffmanDecoding decoding = new HuffmanDecoding();

    //Execute
    String encoded = coding.encode(text);
    HuffmanBinaryTree tree = coding.getTree();
    String decoded = decoding.decode(encoded, tree);

    //Assert
    assertTrue(verifyTree.verify(tree));
    assertEquals(text, decoded);
  }
  
}
