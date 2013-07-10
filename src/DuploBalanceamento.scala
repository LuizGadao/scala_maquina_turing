object DuploBalanceamento
{
  
  def main( args:Array[String] )
  {
    // criando fita e sentando caracteres
    var fita:String = Caractere.INICIO_FITA.getCaractere() + "{{}}";
    
    // estados
    var estadoQ0:Estado = new Estado( "q0", true, false );
    var estadoQ1:Estado = new Estado( "q1", false, false );
    var estadoQ2:Estado = new Estado( "q2", false, false );
    var estadoQ3:Estado = new Estado( "q3", false, true );
    
    // movimentos de Q0
    estadoQ0.addMovimento( new Movimento( estadoQ0, Caractere.INICIO_FITA.getCaractere(), Caractere.INICIO_FITA.getCaractere(), Sentido.DIREITA ) );
    estadoQ0.addMovimento( new Movimento( estadoQ0, 'B', 'B', Sentido.DIREITA ) );
    estadoQ0.addMovimento( new Movimento( estadoQ1, '{', 'A', Sentido.DIREITA ) );
    estadoQ0.addMovimento( new Movimento( estadoQ3, Caractere.VAZIO.getCaractere(), Caractere.VAZIO.getCaractere(), Sentido.ESQUERDA ) );
    
    // movimentos de Q1
    estadoQ1.addMovimento( new Movimento( estadoQ1, '{', '{', Sentido.DIREITA ) );
    estadoQ1.addMovimento( new Movimento( estadoQ1, 'B', 'B', Sentido.DIREITA ) );
    estadoQ1.addMovimento( new Movimento( estadoQ2, '}', 'B', Sentido.ESQUERDA ) );
    
    // movimentos de Q2
    estadoQ2.addMovimento( new Movimento( estadoQ2, 'B', 'B', Sentido.ESQUERDA ) );
    estadoQ2.addMovimento( new Movimento( estadoQ0, 'A', 'A', Sentido.DIREITA ) );
    estadoQ2.addMovimento( new Movimento( estadoQ2, '{', '{', Sentido.ESQUERDA ) );
    
    // criando programa e add estados
    var programa:Programa = new Programa();
    programa.addEstado( estadoQ0 );
    programa.addEstado( estadoQ1 );
    programa.addEstado( estadoQ2 );
    programa.addEstado( estadoQ3 );
    
    // criando maquina e iniciando execução
    var maquina:Maquina = new Maquina( fita, programa );
    maquina.run()
    
    
    Log.log( "FINISH" );
    
  }

}