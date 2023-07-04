/**
 * Clase que implementa un arbol binario de Huffman
 * @Author: <Estudiantes>
 * @Version: <1>
*/

package project;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanBinaryTree {
  private Object key;
  private Object letra;
  private HuffmanBinaryTree left;
  private HuffmanBinaryTree right;

  private HuffmanBinaryTree padre;



  public HuffmanBinaryTree(Object letra,Object key){
    this.letra = (char) letra;
    this.key = key;
    left = null;
    right = null;
  }

  public HuffmanBinaryTree(){

  }


  public void construirArbol(HashMap<Character,Integer> mapaDeFrecuencia){
    PriorityQueue<HuffmanBinaryTree> heap = new PriorityQueue<>(new CompareTreeHuffman());
    for (Map.Entry<Character,Integer> mapa: mapaDeFrecuencia.entrySet()) {
      char letra = mapa.getKey();
      int frecuencia = mapa.getValue();
      //Creo un nodo de Huffman
      HuffmanBinaryTree nodo = new HuffmanBinaryTree(letra,frecuencia);
      heap.offer(nodo);
    }

    //Acomodar el heap
    while (heap.size() > 1){
      HuffmanBinaryTree izquierdo = heap.poll();
      HuffmanBinaryTree derecho = heap.poll();
      int sumarFrecuencia = izquierdo.getNumberKey() + derecho.getNumberKey();
      HuffmanBinaryTree nodoPadre = new HuffmanBinaryTree('+',sumarFrecuencia);
      nodoPadre.setLeft(izquierdo);
      nodoPadre.setRight(derecho);
      heap.offer(nodoPadre);
    }
    this.padre = heap.poll();
  }

  public void imprimirArbol(){
    imprimirArbolRecursivo(padre," ");
  }

  public static void imprimirArbolRecursivo(HuffmanBinaryTree nodo, String prefijo) {
    if (nodo == null) {
      System.out.println(prefijo + "null");
      return;
    }
    char letra = (char) nodo.letra;
    if (letra != ' ') {
      System.out.println(prefijo + "Character: " + letra + ", Frequency: " + nodo.getNumberKey());
    } else {
      System.out.println(prefijo + "Internal Node, Frequency: " + nodo.getNumberKey());
    }

    imprimirArbolRecursivo(nodo.getLeft(), prefijo + "  |---Left: ");
    imprimirArbolRecursivo(nodo.getRight(), prefijo + "  |---Right: ");
  }


  /**
   * Retorna el valor de la llave, si es un string retorna -1, si es un numero retorna el numero.
   * @return valor de la llave
   */
  public int getNumberKey(){
    if (key == null) {
      return -1;
    }
    return (Integer )key;
  }

  /**
   * Retorna el hijo izquierdo del arbol.
   * @return hijo izquierdo del arbol
   */
  public HuffmanBinaryTree getLeft(){
    if(this.left == null){
      return null;
    }
    return this.left;
  }


  /**
   * Retorna el hijo derecho del arbol.
   * @return hijo derecho del arbol
   */
  public HuffmanBinaryTree getRight(){
    if(this.right == null){
      return null;
    }
    return this.right;
  }

  public void setLeft(HuffmanBinaryTree left) {
    this.left = left;
  }

  public void setRight(HuffmanBinaryTree right) {
    this.right = right;
  }

  public HuffmanBinaryTree getPadre() {
    return padre;
  }

  public Object getLetra() {
    return letra;
  }


}
