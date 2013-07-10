object ParImpar
{
  
  def main( args:Array[String] )
  {
    // criando fita e sentando caracteres
    var fita:String = Caractere.INICIO_FITA.getCaractere() + "aa";
    
    // estados
    var estadoQ0:Estado = new Estado( "q0", true, false );
    var estadoQ1:Estado = new Estado( "q1", false, false );
    var estadoQ2:Estado = new Estado( "q2", false, true );
    
    // movimentos de Q0
    estadoQ0.addMovimento( new Movimento( estadoQ0, Caractere.INICIO_FITA.getCaractere(), Caractere.INICIO_FITA.getCaractere(), Sentido.DIREITA ) );
    estadoQ0.addMovimento( new Movimento( estadoQ1, 'a', 'a', Sentido.DIREITA ) );
    estadoQ0.addMovimento( new Movimento( estadoQ2, Caractere.VAZIO.getCaractere(), 'P', Sentido.DIREITA ) );
    
    // movimentos de Q1
    estadoQ1.addMovimento( new Movimento( estadoQ0, 'a', 'a', Sentido.DIREITA ) );
    estadoQ1.addMovimento( new Movimento( estadoQ2, Caractere.VAZIO.getCaractere(), 'I', Sentido.DIREITA ) );
    
    // criando programa e add estados
    var programa:Programa = new Programa();
    programa.addEstado( estadoQ0 );
    programa.addEstado( estadoQ1 );
    programa.addEstado( estadoQ2 );
    
    // criando maquina e iniciando execução
    var maquina:Maquina = new Maquina( fita, programa );
    maquina.run()
    
    
    Log.log( "FINISH" );
  }

}