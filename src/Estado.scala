import scala.collection.JavaConversions._

class Estado( _nome:String, _estadoInicial:Boolean, _estadoFinal:Boolean )
{
  
  private var nome 			= _nome;
  private var estadoInicial = _estadoInicial;
  private var estadoFinal 	= _estadoFinal;
  private var movimentos  	= new java.util.ArrayList[Movimento] //java.util.ArrayList[Movimento]();  //List(); //List[Movimento];
 
  // val constante
  
  def addMovimento( novoMovimento:Movimento )
  {    
    movimentos.add( novoMovimento );    
  }
  
  
  def equals( estado:Estado ):Boolean =
  {
    var resp = false;
    
    // compara nome e se tem os estado inicial e final é o mesmo
    if ( estado != null && estado.getNome() == this.getNome() && estado.isEstadoInicial() == this.isEstadoInicial() && estado.isEstadoFinal() == this.isEstadoFinal() )
      resp = true;
    
    resp;
  }
  
  override def toString():String=
  {
    var str = new String( "estado: " + this.getNome() + " é estado inicial " + this.isEstadoInicial() + " é estado final " + this.isEstadoFinal() );
    str;
  }
  
  //--------------------- METODOS GET ---------------------------------------
  def isEstadoInicial()= estadoInicial;
  def isEstadoFinal()= estadoFinal;
  def getNome():String = this.nome;
  def getMovimentos():java.util.ArrayList[Movimento] = this.movimentos;
 
  
  

}