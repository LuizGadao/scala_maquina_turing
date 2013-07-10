object Caractere
{
  
  val INICIO_FITA:Caractere = new Caractere( '#' );
  val VAZIO:Caractere 		= new Caractere( '$' );
  
}

class Caractere( _novoCaractere:Char )
{
  
  private var _caractere = _novoCaractere;
  
  def getCaractere():Char = this._caractere;
  
 }