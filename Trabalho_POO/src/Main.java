import java.util.Scanner;

import Entities.Sistema;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            System.out.println("0 - Sair do programa");
            System.out.println("1 - Adicionar participante");
            System.out.println("2 - Remover participante");
            System.out.println("3 - Editar participante");

            System.out.println("4 - Adicionar palestrante");
            System.out.println("5 - Remover palestrante");
            System.out.println("6 - Editar palestrante");

            System.out.println("7 - Inscrever participante em palestra");
            System.out.println("8 - Desinscrever participante em palestra");

            System.out.println("9 - Adicionar Local");
            System.out.println("10 - Remover Local");
            System.out.println("11 - Editar Local");

            System.out.println("12 - Adicionar palestra");
            System.out.println("13 - Remover palestra");
            System.out.println("14 - Editar palestra");

            System.out.println("15 - Gerar lista de presença");
            System.out.println("16 - Listar locais e suas palestras");
            System.out.println("17 - Listar palestras de um participante");
            try{
                Integer choice = sistema.getInteger(sc, "Qual ação você deseja fazer ?: ");
                if(choice == 0){
                    break;
                }
                else if(choice == 1){
                    sistema.AddParticipante(sc);
                }
                else if(choice == 2){
                    sistema.RemoveParticipante(sc);
                }
                else if(choice == 3){
                    sistema.EditParticipante(sc);
                }
                else if(choice == 4){
                    sistema.AddPalestrante(sc);
                }
                else if(choice == 5){
                    sistema.RemovePalestrante(sc);
                }
                else if(choice == 6){
                    sistema.EditPalestrante(sc);
                }
                else if(choice == 7){
                    sistema.Inscricao(sc);
                }
                else if(choice == 8){
                    sistema.RemoverInscricao(sc);
                }
                else if(choice == 9){
                    sistema.AddLocal(sc);
                }
                else if(choice == 10){
                    sistema.RemoveLocal(sc);
                }
                else if(choice == 11){
                    sistema.EditLocal(sc);
                }
                else if(choice == 12){
                    sistema.AddPalestra(sc);
                }
                else if(choice == 13){
                    sistema.RemovePalestra(sc);
                }
                else if(choice == 14){
                    sistema.EditPalestra(sc);
                }
                else if(choice == 15){
                    sistema.lista_presenca(sc);
                }
                else if(choice == 16){
                    sistema.lista_local_e_palestras();
                }
                else if(choice == 17){
                    sistema.palestras_de_participante(sc);
                }
                else{
                    System.out.println("Valor inválido");
                }
            }
            catch(Exception exception){
                System.out.println("\n" + exception.getMessage() + "\n");
            }
        }
        sc.close();
    }
}
