/*
	========================================
	TRABALHO FINAL DE ORIENTAÇÃO A OBJETOS I
	========================================

	NOMES:
		IAGO SCHLISTING IZOLAN MACHADO
		VANDER PAPKE
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public Scanner keyboard = new Scanner(System.in);
    public ArrayList<Carro> carros = new ArrayList<Carro>();
    public ArrayList<Motocicleta> motos = new ArrayList<Motocicleta>();
    public ArrayList<Caminhao> caminhoes = new ArrayList<Caminhao>();


	public static void main(String[] args){
		Main main = new Main();
		main.start();
	}

	public void start(){

		// Carga inicial
		ArrayList<String> veiculos = new ArrayList<String>();
		veiculos.add("IRS-2245, 12, 85.50, A");
		veiculos.add("ISW-5589, 25, 3.90, M");
		veiculos.add("ITT-1444, 35, 90.35, C");
		veiculos.add("ATT-8901, 22, 15.00, A");

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
            	menu.listarTodos();
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
        Caminhao caminhao;


      	String placa;
      	int contagem;
      	Double saldo;
      	String tipo;

        String[] parte;
		for(String veiculo : veiculos)
		{
			parte = veiculo.split(",");
			//tratando dados.
			placa = parte[0].replaceAll("\\s+","");
			contagem = Integer.parseInt(parte[1].replaceAll("\\s+",""));
			saldo = Double.parseDouble(parte[2].replaceAll("\\s+",""));
			tipo  = parte[3].replaceAll("\\s+","");

			if(tipo.equals("A"))
			{
				carro = new Carro(placa, contagem, saldo);
				this.carros.add(carro); 	
			}

			if(tipo.equals("M"))
			{
				moto = new Motocicleta(placa, contagem, saldo);	
				this.motos.add(moto);
			}
			if(tipo.equals("C")){
				caminhao = new Caminhao(placa, contagem, saldo);
				this.caminhoes.add(caminhao);
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
	        System.out.println(" 5. LISTAR TODOS OS VEICULOS  ");
	        System.out.println(" 99. SAIR DO PROGRAMA		  ");
	        System.out.println("==============================");
	    }

	    public void saldoInsuficienteAviso(){
	    	System.out.println("------------------------------------");
			System.out.println("      AVISO: SALDO INSUFICIENTE!!!  ");
			System.out.println("------------------------------------\n");
	    }

	    public void veiculoNaoCadastradoAviso(){
	    	System.out.println("--------------------------------------------");
			System.out.println(" AVISO: Veiculo nao cadastrado no sistema!! ");
			System.out.println("--------------------------------------------\n");
	    }

	    public void veiculoJaCadastradoAviso(){
	    	System.out.println("--------------------------------------------");
			System.out.println(" AVISO: Veiculo já cadastrado no sistema!!  ");
			System.out.println("--------------------------------------------\n");
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

			for(Caminhao caminhao : caminhoes){
				if(placa.equals(caminhao.getPlaca())){
					caminhao.mostraVeiculo();
				}else{
					count++;
				}
			}


			if(count == motos.size() + carros.size() + caminhoes.size()){
				this.veiculoNaoCadastradoAviso();
			}
	    }

	    
	    public void passaPedagio(){

	    	keyboard = new Scanner(System.in);
	        System.out.println("Qual a placa do veiculo?");
	        String placa = keyboard.nextLine();
	        int count = 0;

			for(Carro carro : carros){
				if(placa.equals(carro.getPlaca())){
					if(carro.getSaldo() < 3.50){
						this.saldoInsuficienteAviso();
					}else{
						carro.setSaldo(carro.getSaldo() - 3.50);
						carro.setContagem(carro.getContagem() + 1);
					}
				}else{
					count++;
				}
			}

			for(Motocicleta moto : motos){
				if(placa.equals(moto.getPlaca())){
					if(moto.getSaldo() < 1.50){
						this.saldoInsuficienteAviso();
					}else{
						moto.setSaldo(moto.getSaldo() - 1.50);
						moto.setContagem(moto.getContagem() + 1);
					}
				}else{
					count++;
				}
			}

			for(Caminhao caminhao : caminhoes){
				if(placa.equals(caminhao.getPlaca())){
					if(caminhao.getSaldo() < 5.00){
						this.saldoInsuficienteAviso();
					}else{
						caminhao.setSaldo(caminhao.getSaldo() - 5.00);
						caminhao.setContagem(caminhao.getContagem() + 1);
					}
				}else{
					count++;
				}
			}

			if(count == motos.size() + carros.size() + caminhoes.size()){
				this.veiculoNaoCadastradoAviso();
			}

	    }
	    
	    public void recaregaSaldo(){
	    	keyboard = new Scanner(System.in);
	        System.out.println("Qual a placa do veiculo?");
	        String placa = keyboard.nextLine();
	        int count = 0;
	        Double valor_recarga;

			for(Carro carro : carros){
				if(placa.equals(carro.getPlaca())){
					System.out.println("Digite o valor da recarga para o veiculo " + placa + ":");
					valor_recarga = keyboard.nextDouble();
					carro.setSaldo(carro.getSaldo() + valor_recarga);
				}else{
					count++;
				}
			}

			for(Motocicleta moto : motos){
				if(placa.equals(moto.getPlaca())){
					System.out.println("Digite o valor da recarga para o veiculo " + placa + ":");
					valor_recarga = keyboard.nextDouble();
					moto.setSaldo(moto.getSaldo() + valor_recarga);
				}else{
					count++;
				}
			}

			for(Caminhao caminhao : caminhoes){
				if(placa.equals(caminhao.getPlaca())){
					System.out.println("Digite o valor da recarga para o veiculo " + placa + ":");
					valor_recarga = keyboard.nextDouble();
					caminhao.setSaldo(caminhao.getSaldo() + valor_recarga);
				}else{
					count++;
				}
			}

			if(count == motos.size() + carros.size() + caminhoes.size()){
				this.veiculoNaoCadastradoAviso();
			}
	    }

	    public void cadastraVeiculo(){

	    	keyboard = new Scanner(System.in);
	        System.out.println("Qual a placa do veiculo a ser cadastrado no sistema?");
	        String placa = keyboard.nextLine();
	        int count = 0;
	        Double valor_recarga;

			for(Carro carro : carros){
				if(placa.equals(carro.getPlaca())){
					this.veiculoJaCadastradoAviso(); 
				}else{
					count++;
				}
			}

			for(Motocicleta moto : motos){
				if(placa.equals(moto.getPlaca())){
					this.veiculoJaCadastradoAviso();
				}else{
					count++;
				}
			}

			for(Caminhao caminhao : caminhoes){
				if(placa.equals(caminhao.getPlaca())){
					this.veiculoJaCadastradoAviso();
				}else{
					count++;
				}
			}

			if(count == motos.size() + carros.size() + caminhoes.size()){
				System.out.println("O veiculo é carro ou moto? [A / M / C]");
	        	String tipo = keyboard.nextLine();

	        	ArrayList<String> veiculos = new ArrayList<String>();
				veiculos.add(placa+", 0, 0.0, " + tipo);
	        	convertVeiculosIntoObjects(veiculos);
			}
	    }

	    public void listarTodos(){
	    	for(Carro carro : carros){
				carro.mostraVeiculo();
			}

			for(Motocicleta moto : motos){
				moto.mostraVeiculo();
			}

			for(Caminhao caminhao : caminhoes){
				caminhao.mostraVeiculo();
			}
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

	public class Caminhao extends Veiculo{
		public Caminhao(String placa, Integer contagem, Double saldo){
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