package Pedagio;

import java.util.Scanner;

public class Menu {
    
    private static Scanner entrada;

	public static void menu(){
        System.out.println("\n\tCONTROLE DE PEDAGIO");
        System.out.println(" 1. SALDO DO VEICULO");
        System.out.println(" 2. CANCELA AUTOMATICA");
        System.out.println(" 3. RECARGA DE VEICULO");
        System.out.println(" 4. CADASTRO DE VEICULO");
        System.out.println(" 5. SALVAR DADOS EM ARQUIVO");
        System.out.println("99. SAIR DO PROGRAMA");
        System.out.println("Opcao:");
    }

    public static void verificaSaldo(){
        System.out.println("Você entrou no método saldo.");
    }
    
    public static void passaPedagio(){
        System.out.println("Você entrou no método cancela automatica.");
    }
    
    public static void recaregaSaldo(){
        System.out.println("Você entrou no método recarga de veiculo.");
    }
    public static void cadastraVeiculo(){
        System.out.println("Você entrou no método recarga de veiculo.");
    }
    
    public static void salvaDados(){
        System.out.println("Você entrou no método salvar dados.");
    }
    
    public static void main(String[] args) {
        int opcao;
        char sair;
        entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
            	verificaSaldo();
                break;
                
            case 2:
            	passaPedagio();
                break;
                
            case 3:
            	recaregaSaldo();
                break;
                
            case 4:
            	cadastraVeiculo();
                break;
                
            case 5:
            	salvaDados();
                break;
                
            case 99:
            	System.out.println("Deseja mesmo ENCERRAR o progranma(s/n)?");
            	sair = entrada.next().charAt(0);
            	
            	if (sair == 's'||sair == 'S' )
            		opcao = 99;
            	
            	else 
            		opcao = 0;
            	
            	break;
            	
            	
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 99);
        
        System.out.println("\n PROGRAMA ENCERRADO!");
    }
}
