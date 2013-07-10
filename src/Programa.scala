import scala.collection.JavaConversions._

class Programa
{
  
  // coleção de estados
  private var estados = new java.util.ArrayList[ Estado ];
  
  
  def addEstado( novoEstado:Estado )
  { 
   
    // verifica se existe um estado igual a este, já cadastrado    
    for ( estadoExistente <- this.getEstados() )
    {
      
      if ( estadoExistente.equals( novoEstado ) )
      {        
        //println("estado igual" + estadoExistente.getNome() + " = " + novoEstado.getNome() );
        throw new TuringException( "Estado existente" );
      }
    }
    
    this.estados.add( novoEstado );   
    
    
    /* TESTE DE LANÇAMENTO DE EXCEÇÃO PELO MÉTODO VERIFICAESTADOEXISTENTE */
    /*
    try
    {
      verificaEstadoExistente( novoEstado );
      this.estados.add( novoEstado );
    }
    catch
    {
      //case _ => println("ocorreu qualquer error");
      case e:TuringException =>  throw e; //println( e.getError() ); 
    }
    this.estados.add( novoEstado );
    */
  }
  
 //@throws(classOf[TuringException])
  def verificaEstadoExistente( novoEstado:Estado )
  {
	for ( estadoExistente <- this.getEstados() )
    {
      
      if ( estadoExistente.equals( novoEstado ) )
      {
        println("estado igual " + estadoExistente.getNome() + " = " + novoEstado.getNome() );
        throw new TuringException( "Estado existente" );
      }
    }
  }
  
  // captura estados
  def getEstados():java.util.ArrayList[ Estado ] = this.estados;

}