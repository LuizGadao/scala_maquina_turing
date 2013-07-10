import scala.collection.JavaConversions;

class Maquina( _fita:String, _programa:Programa )
{
  
  private var fita 		= _fita;
  private var programa 	= _programa;
  var uControle:UnidadeControle = null;
  
 def run()=
 {
   
   /* criando UNIDADE DE CONTROLE, E PASSANDO COMO PARAMENTRO O ESTADO INICIAL E A M�QUINA
    * Estou passando a M�QUINA, n�o consigo alterar a fita passada para o m�todo (executaMovimento) da unidade de controle.
    * Passando a maquina eu consigo acessar o get da fita e altera-l�
    * 
    * ESSE PRIMEIRO try ERA PARA ESTAR NO CONSTRUTOR, MAS APENAS CONSEGUIR CRIA-LO DE MANEIRA IMPLIC�TA
    */
   try
   {
     uControle = new UnidadeControle( this.buscaEstadoInicial( _programa.getEstados() ), this );
   }
   catch
   {
     case e:TuringException => Log.log( e.getError() );     
   }   
   
   try
   {     
     
     // loop na unidade de controle, e ela que termina quando o programa terminou
     do
     {
       // aloca mais espa�o na fita
       if ( uControle.getPosicaoAtual() >= fita.length() ) this.populaEspacoVazio();
       
       // executa um novo movimento
       uControle.executaMovimento( this.programa, this.fita );
     } while(!  uControle.isEncerraExecucao() )
     
   }
   catch
   {
     case e:TuringException => Log.log( e.getError() );
     case e:Exception => Log.log( e.getMessage() );
   }
   
 }
 
 // populando espa�o fazio com $
 def populaEspacoVazio()=
 {
   // concatenando espa�o fazio no final da string
   this.fita = appendString( _fita, Caractere.VAZIO.getCaractere() );
 } 
 
 def appendString( str:String, char:Char ):String =
 {
   str + char;
 }
 
  // captura estado inicial da m�quina
  def buscaEstadoInicial( estados:java.util.ArrayList[ Estado ] ):Estado =
  {
    // boolena que vai verifica se tem mais de um estado inicial
    var estadoInicial = false;
    var i = 0;
    var nEstadoInicial = 10000;
    
    // loop nos estados
    while ( i < estados.size()  )
    {
      var estado = estados.get( i );
      
      if ( estado.isEstadoInicial() )
      {
        if ( estadoInicial == false )
        {
          estadoInicial = true;
          nEstadoInicial = i;
        }
        else
          throw new TuringException( "M�quina deve possuir apenas um estado inicial" );
      }
      
      i += 1;
    }
    
    // verifica se achou o estado inicial
     if ( nEstadoInicial == 10000 )
     {
       throw new TuringException( "M�quina n�o possui estado inicial" );
     }
     
     //retorna estado inicial
     estados.get(nEstadoInicial);
  }
  
  def getFita():String=
  {
    this._fita;
  }
  
  def setFita( novaFita:String )=
  {
    this.fita = novaFita;
  }

}