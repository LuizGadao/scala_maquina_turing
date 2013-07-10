object Main
{
  
  def main( args : Array[String] )
  {
    //var n = 0;
    var t = "STR";        
    //var tt = "f";
    //var ttt = t.slice(0, n-1) + tt + t.slice(n, t.length());
    
    t =  setCharAt(t, 0, 'f');
    t = appendString( t, '$');
    
    println( t + " " );
    
    //testeLoopUnidadeControle();    
    
    println( "finish" );
  }
  
  def appendString( str:String, char:Char ):String =
  {
    str + char;
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
  
  def testeEstados()=
  {
    var estado = new Estado("q1", true, false);
    var estadoA = new Estado("q2", true, false);
    var estadoB = new Estado("q2", true, false);
    
    // teste na mão    
    //println(estado.isEstadoInicial(), estado.isEstadoFinal());
    //println(estadoA.equals(estado))
    
    println( Sentido.DIREITA.getSimbolo() );
    
    var programa = new Programa();
    try
    {
    	programa.addEstado( estado );
    	programa.addEstado( estadoA );
    	programa.addEstado( estadoB );
    }
    catch
    {
       case e:TuringException =>  println( e.getError() ); 
    }
    //programa.addEstado( estadoA );
  }
  
  def testeLoopUnidadeControle()=
  {
    var estado = new Estado("q1", true, false);
    var estadoA = new Estado("q2", true, false);
    var estadoB = new Estado("q2", true, false);
    
    var movA = new Movimento( estado, Caractere.INICIO_FITA.getCaractere(), Caractere.INICIO_FITA.getCaractere(), Sentido.DIREITA );
    var movB = new Movimento( estadoA, 'a', 'A', Sentido.DIREITA );
    
    estado.addMovimento( movA );
    estado.addMovimento( movB );
    
    //var unidade = new UnidadeControle( estado );
    //unidade.executaMovimento();
  }

}