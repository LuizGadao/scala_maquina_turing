import scala.collection.JavaConversions;

class UnidadeControle( estadoInicial:Estado, _maquina:Maquina )
{
  
  private var estadoAtual 	= estadoInicial;
  private var maquina		= _maquina;
  
  private var encerraExecucao = false;
  private var posicaoAtualFita = 0;
  
  
  def executaMovimento( programa:Programa, fita:String )
  {
    this.estadoAtual.getMovimentos()
	
    //capturando movimentos
    var movimentos = this.estadoAtual.getMovimentos();    
    var i = 0;
    
    // loop nos movimentos do estado
    while ( i < movimentos.size() )
    {
      // captura movimento atual
      var mov = movimentos.get(i);
      
      // verifica se o caractere lido não é o mesmo da posição atual
      if ( mov.getCaracterLido() == fita.charAt( posicaoAtualFita ) )
      {
        
        //captura caracter novo, do movimento
        var caracterNovo = mov.getCaractereNovo();
        //set o char novo na posição atual da fita
        var novaFita = setCharAt( fita, posicaoAtualFita, caracterNovo );
        
        //------------- NÃO ACEITA INSCREVER NA FITA -------------------------
        //fita = setCharAt( fita, posicaoAtualFita, caracterNovo );
        
        //---------- ALTERANDO O VALOR DA FITA ----------------------
        maquina.setFita( novaFita );
        
        // não aceita 
        //fita = setCharAt( fita, posicaoAtualFita, caracterNovo );
        
        // faz o log da fita
        printaPrograma( mov );
        Log.log( "fita agora: " + novaFita + " posição atual: " + posicaoAtualFita + " caractere na posicao atual " + novaFita(posicaoAtualFita) + " estado atual:" + estadoAtual.getNome() ); 
        
        //seta novo estado
        this.estadoAtual = mov.getEstadoDestino();
        
        if ( mov.getSentido() == Sentido.DIREITA )
          this.posicaoAtualFita += 1
        else
          this.posicaoAtualFita -= 1
        
        
        if ( this.posicaoAtualFita < 0 )
        {
           throw new TuringException( "Máquina está na posição anterior a 0, contém erros" );
        }
        
        return;  
      }
      
      i += 1;
    }
    
    //
    if ( this.estadoAtual.isEstadoFinal() )
    {
      this.encerraExecucao = true;
    }
    else
    {
      Log.log( this.estadoAtual.getNome() + " " + posicaoAtualFita + " " + maquina.getFita()(posicaoAtualFita) );
      throw new TuringException( "Máquina não chegou ao estado final, logo não reconheceu a lógica do programa" );
    }
    
  }
  
  def printaPrograma( mov:Movimento )=
  {
    Log.log( "H(" + this.getEstadoAtual().getNome() + "," + mov.getCaracterLido() + ") = H(" + mov.getEstadoDestino().getNome()
        + "," + mov.getCaractereNovo() + "," + mov.getSentido().getSimbolo() + ");"  ); 
  }
  
   def setCharAt( str:String, index:Int, char:Char ):String=
  {    
    var n = index;
    
    var crop1 = "";
    var crop2 = "";
    
    if ( index != 0 ) crop1 =  str.slice(0, n)
    
    if ( index < str.length() ) crop2 = str.slice( index+1, str.length() )
    
   // =  + char + result.slice(n, result.length());
    println( crop1 )
    println( char )
    println( crop2 )
    
    crop1 + char + crop2; 
  }
  
   //--------------------- METODOS GET ---------------------------------------
  def isEncerraExecucao()= this.encerraExecucao;
  def getPosicaoAtual():Int = this.posicaoAtualFita;
  def getEstadoAtual():Estado = this.estadoAtual;

}