import scala.util.control.Exception

class TuringException( _message:String ) extends Exception( "Turing EXCEPTION => " + _message ) // LANÇA EXCEÇÃO DIRETAMENTE NO CONSTRUTOR
{
  private var error = _message;
  
  def getError():String = this.error;
}