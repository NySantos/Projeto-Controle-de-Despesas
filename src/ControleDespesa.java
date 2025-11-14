import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ControleDespesa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<Despesas> list = new ArrayList<>();
        double total = 0.0;
        int opcao = 0;
        double caro = 0.0;



        do {
            System.out.println("==== MENU ====");
            System.out.println("1 - Adicionar nova despesa");
            System.out.println("2 - Listar todas as despesas");
            System.out.println("3 - Mostrar total gasto");
            System.out.println("4 - Mostrar a despesa mais cara");
            System.out.println("5 - Filtrar por categoria");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Quantas despesas deseja adicionar? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Despesa #" + (i + 1));
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();
                        System.out.print("Categoria: ");
                        String categoria = sc.nextLine();
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();
                        list.add(new Despesas(descricao, categoria, valor));
                        total += valor;
                        if(valor > 0){
                            caro = valor;
                        }
                        else if (caro <= valor){
                            caro = valor;
                        }
                        System.out.println("Despesa adicionada!");
                        System.out.println();
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("Listar todas as Despesas");
                    for (Despesas d : list) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    System.out.printf("Mostrar o total gasto ate agora: R$ %.2f%n", total);

                    break;

                case 4:
                    System.out.println("Despesa mais Cara: ");
                    System.out.println(caro);
                    break;

                case 5:
                    System.out.println("Categorias disponíveis:");
                    for (Despesas d : list) {
                        System.out.println("- " + d.getCategoria());
                    }
                    System.out.println();

                    System.out.print("Digite a categoria que deseja filtrar: ");
                    String categoriaFiltro = sc.nextLine();

                    boolean encontrou = false;
                    System.out.println("Despesas da categoria '" + categoriaFiltro + "':");

                    for (Despesas d : list) {
                        if (d.getCategoria().equalsIgnoreCase(categoriaFiltro)) {
                            System.out.println(d);
                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Nenhuma despesa encontrada nessa categoria.");
                    }

                    System.out.println();
                    break;

                case 0:
                    System.out.println("Encerrando Programa.");
                    break;

                default:
                    System.out.println("Opção invalida");
                    break;

            }

        } while (opcao != 0);





        sc.close();
    }
}
