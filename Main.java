import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public Scanner keyboard = new Scanner(System.in);
	public Carro carros[] = new Carro[3];
    public Motocicleta motos[] = new Motocicleta[1];
    public int carroIndex = 0;
    public int motoIndex = 0; 

	public static void main(String[] args){
		Main main = new Main();
		main.start();
	}

	public void start(){

		// Carga inicial
		ArrayList<String> veiculos = new ArrayList<String>();
		veiculos.add("IRS-2245, 12, 85.50, A");
		veiculos.add("ISW-5589, 25, 13.90, M");
		veiculos.add("ITT-1444, 35, 90.35, A");
		veiculos.add("ATT-8901, 22, 150.00, A");


		this.convertVeiculosIntoObjects(veiculos);

		int opcao;
        char sair;
        Menu menu = new Menu();
        
        do{
            menu.showMenu();
            opcao = keyboard.nextInt();
            
            switch(opcao){
            case 1:
            	menu.verificaSaldo();
                break;
                
            case 2:
            	menu.passaPedagio();
                break;
                
            case 3:
            	menu.recaregaSaldo();
                break;
                
            case 4:
            	menu.cadastraVeiculo();
                break;
                
            case 5:
            	menu.salvaDados();
                break;
                
            case 99:
            	System.out.println("Deseja encerrar o progranma(s/n)?");
            	sair = keyboard.next().charAt(0);
            	
            	if (sair == 's'||sair == 'S' )
            		opcao = 99;
            	
            	else 
            		opcao = 0;
            	
            	break;
            	
            	
            default:
                System.out.println("Opcao invalida.");
            }
        } while(opcao != 99);
        
        System.out.println("\n Programa encerrado.");

	}

	public void convertVeiculosIntoObjects(ArrayList<String> veiculos){
		Carro carro;
        Motocicleta moto;
      	String placa;
      	int contagem;
      	Double saldo;
      	String tipo;

        String[] parte;
		for(String veiculo : veiculos)
		{
			parte = veiculo.split(",");
			//tratando dados de entrada.
			placa = parte[0].replaceAll("\\s+","");
			contagem = Integer.parseInt(parte[1].replaceAll("\\s+",""));
			saldo = Double.parseDouble(parte[2].replaceAll("\\s+",""));
			tipo  = parte[3].replaceAll("\\s+","");

			if(tipo.equals("A"))
			{
				carro = new Carro(placa, contagem, saldo);
				this.carros[this.carroIndex] = carro;
				this.carroIndex++; 	
			}

			if(tipo.equals("M"))
			{
				moto = new Motocicleta(placa, contagem, saldo);	
				this.motos[this.motoIndex] = moto;
				this.motoIndex++;
			}
		}
	}


	public class Menu {
	    
		public void showMenu(){
			System.out.println("==============================");
	        System.out.println("      CONTROLE DE PEDAGIO     ");
	        System.out.println("==============================");
	        System.out.println(" 1. SALDO DO VEICULO          ");
	        System.out.println(" 2. CANCELA AUTOMATICA		  ");
	        System.out.println(" 3. RECARGA DE VEICULO		  ");
	        System.out.println(" 4. CADASTRO DE VEICULO		  ");
	        System.out.println(" 5. SALVAR DADOS EM ARQUIVO	  ");
	        System.out.println(" 99. SAIR DO PROGRAMA		  ");
	        System.out.println("==============================");
	    }

	    public void verificaSaldo(){
	    	keyboard = new Scanner(System.in);
	        System.out.println("Qual a placa do veiculo?");
	        String placa = keyboard.nextLine();
	        int count = 0;

			for(Carro carro : carros){
				if(placa.equals(carro.getPlaca())){
					carro.mostraVeiculo();
				}else{
					count++;
				}
			}

			for(Motocicleta moto : motos){
				if(placa.equals(moto.getPlaca())){
					moto.mostraVeiculo();
				}else{
					count++;
				}
			}

			if(count == motos.length + carros.length){
				System.out.println("Veiculo nao cadastrado no sistema.\n");
			}
	    }

	    
	    public void passaPedagio(){

	    	keyboard = new Scanner(System.in);
			System.out.println("Qual a placa do veiculo?");
	        String placa = keyboard.nextLine();

	    }
	    
	    public void recaregaSaldo(){
	        System.out.println("Voc� entrou no m�todo recarga de veiculo.");
	    }
	    public void cadastraVeiculo(){
	        System.out.println("Voc� entrou no m�todo cadastra de veiculo.");
	    }
	    
	    public void salvaDados(){
	        System.out.println("Voc� entrou no m�todo salvar dados.");
	    }
	}



	public class Carro extends Veiculo {
		public Carro(String placa, Integer contagem, Double saldo){
			super(placa, contagem, saldo);
		}
	}

	public class Motocicleta extends Veiculo{
		public Motocicleta(String placa, Integer contagem, Double saldo){
			super(placa, contagem, saldo);
		}
	}

	public class Veiculo {

		protected String placa;
		protected Double saldo;
		protected Integer contagem; 

		public Veiculo(String placa, Integer contagem, Double saldo){
			this.placa = placa;
			this.saldo = saldo;
			this.contagem = contagem;
		}

		public void mostraVeiculo(){
			System.out.println("--------------------------");
			System.out.println("Veiculo placa: " + this.getPlaca());
			System.out.println("Saldo: " + this.getSaldo());
			System.out.println("Número de passagens: " + this.getContagem());
			System.out.println("--------------------------\n");
		}

		public String getPlaca() {
			return this.placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public Double getSaldo() {
			return this.saldo;
		}
		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}
		public Integer getContagem() {
			return this.contagem;
		}
		public void setContagem(Integer contagem) {
			this.contagem = contagem;
		}

	}



}