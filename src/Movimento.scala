class Movimento( _estadoDestino:Estado, _caractereLido:Char, _caractereNovo:Char, _sentido:Sentido )
{
  
  private var estadoDestino 	= _estadoDestino;
  private var caractereLido 	= _caractereLido;
  private var caractereNovo 	= _caractereNovo;
  private var sentido			= _sentido;
  
  
  def equals( movimento:Movimento ):Boolean =
  {
    var resp = false;
    
    if ( movimento != null && movimento.getCaracterLido() == this.getCaracterLido() )
      resp = true;
    
    resp;
  }
  
   //--------------------- METODOS GET ---------------------------------------
  def getCaracterLido():Char = this._caractereLido;
  def getEstadoDestino():Estado = this._estadoDestino;
  def getCaractereNovo():Char = this.caractereNovo;
  def getSentido():Sentido = this.sentido;
}