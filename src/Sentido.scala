object Sentido
{
  
  val DIREITA:Sentido 	= new Sentido( "->" );
  val ESQUERDA:Sentido 	= new Sentido( "<-" );  
  
}

class Sentido( novoSimbolo:String )
{ 
  
  private var _simbolo = novoSimbolo;
  
  def getSimbolo():String = this._simbolo;
  
}