import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo{
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "MONICA"};
      for(String candidato: candidatos){
            entrandoEmContato(candidato);
      }
    }
    
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando= true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else 
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
                
        }while(continuarTentando && tentativasRealizadas < 3);
        
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA REALIZADA");
        else    
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato + ", NUMERO MAXIMO DE TENTATIVA EXCEDIDO!");
    }

    static boolean  atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimriSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "MONICA"};
        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidado de numero " + (indice+1) + " é " + candidatos[indice]);
        }
    }

    static  void selecionarCandidato(){

        String candidatos [] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        
        int candidatoSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;    
        while(candidatoSelecionados < 5){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para vaga");
                candidatoSelecionados++;
            }
            candidatosAtual++;
        }
        
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO");
        else if (salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }

    static  double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
