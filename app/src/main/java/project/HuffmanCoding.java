/**
 * Clase huffmanCoding
 * Esta clase se encarga de codificar un texto en base a un arbol de huffman
 * @Author: <Estudiantes>
 * @Version: <1>
 */
package project;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HuffmanCoding {

  private HuffmanBinaryTree arbol;
  private HashMap<String, String> mapaCodificado;

  private String cadena;

  private String cadenaCodificada;
  /**
   * Constructor de la clase HuffmanCoding.
   * @param text texto a codificar
   * @return texto codificado
   */
  public String encode(String text) {
    this.cadena = text;
    HashMap<Character,Integer> mapaDeFrecuencia = FrequencyTable.generateTable(text);
    for (char letra : mapaDeFrecuencia.keySet()) {
      int frequencia = mapaDeFrecuencia.get(letra);
      System.out.println("'" + letra + "' : " + frequencia);
    }
    this.arbol = new HuffmanBinaryTree();
    this.arbol.construirArbol(mapaDeFrecuencia);
    //arbol.imprimirArbol();
    this.mapaCodificado = getTable();
    //imprimirTablaCodigo();
    StringBuilder codificado = new StringBuilder();
    for (String letra : text.split("")) {
      String codigo = mapaCodificado.get(letra);
      if(codigo != null){
        codificado.append(codigo);
      }
    }
    this.cadenaCodificada = codificado.toString();
    return  codificado.toString();
  }

  /**
   * Retorna el arbol de huffman.
   * @return arbol de huffman
   */
  public HuffmanBinaryTree getTree() {
    return this.arbol;
  }

  /**
   * Retorna la tabla de codificacion.
   * @return tabla de codificacion
   */
  public HashMap<String,String> getTable() {
    HashMap<String,String> tabla = new HashMap<>();
    generarTablaCodigosRecursivos(arbol.getPadre(),"",tabla);
    return tabla;
  }
  public void imprimirTablaCodigo(){
    for (String letra : mapaCodificado.keySet()) {
      String codigo = mapaCodificado.get(letra);
      System.out.println("'" + letra + "' : " + codigo);
    }
  }

  private HashMap<String,String> generarTablaCodigosRecursivos(HuffmanBinaryTree nodo,String codigoActual,HashMap<String,String> tabla){
    if(nodo != null){
      String letra = nodo.getLetra().toString();
      if(!letra.equals("+")){
        tabla.put(letra,codigoActual);
      }else{
        generarTablaCodigosRecursivos(nodo.getLeft(),codigoActual+"0",tabla);
        generarTablaCodigosRecursivos(nodo.getRight(),codigoActual+"1",tabla);
      }
    }
    return  tabla;
  }
  
  /**
   * Retorna el resumen de la codificacion
   * @return resumen de la codificacion en formato string
   */
  public HashMap<String,String> getSummary() {
    int nodos = contarNodos();
    double resultadoCompresion = compresion();
    int profundidad = profundidad();
    HashMap<String,String>  mapa = new HashMap<>();
    mapa.put("Porcentaje de compresion",String.format("%.4f", resultadoCompresion)+"%");
    mapa.put("Nodos",String.valueOf(nodos));
    mapa.put("Profundidad",String.valueOf(profundidad));
    return mapa;
  }

  private double compresion(){
    int ascii = cadena.length() * 256;
    int cadenaTamanio = cadenaCodificada.length();
    return (1-((double)  cadenaTamanio / ascii))*100;
  }

  public int contarNodos(){
    if(this.arbol.getPadre() == null){
      return 0;
    }

    int contador = 0;
    Queue<HuffmanBinaryTree> cola = new LinkedList<>();
    cola.add(this.arbol.getPadre());

    while (!cola.isEmpty()) {
      HuffmanBinaryTree currentNode = cola.poll();
      contador++;

      if (currentNode.getLeft() != null) {
        cola.add(currentNode.getLeft());
      }

      if (currentNode.getRight() != null) {
        cola.add(currentNode.getRight());
      }
    }

    return contador;
  }

  public int profundidad(){
    if(this.arbol.getPadre() == null){
      return 0;
    }
    Queue<HuffmanBinaryTree> queue = new LinkedList<>();
    queue.add(this.arbol.getPadre());
    int depth = 0;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        HuffmanBinaryTree currentNode = queue.poll();

        if (currentNode.getLeft() != null) {
          queue.add(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
          queue.add(currentNode.getRight());
        }
      }
      depth++;
    }

    return depth;
  }



}
