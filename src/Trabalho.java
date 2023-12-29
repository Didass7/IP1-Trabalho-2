import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamMax = 100;
        String[] nome = new String[tamMax];
        double[] quanto = new double[tamMax];
        double[] preco = new double[tamMax];
        boolean[] feito = new boolean[tamMax];
        int nItens = 0;

        apresentarMenuPrincipal(scanner, nome, quanto, preco, feito, nItens);
    }

    public static String apresentarEditarLista() {
        String editarLista = "----------------------------------------\n"
                + "(I)nserir item no fim da lista.\n"
                + "Inserir item na (p)osição n da lista.\n"
                + "(A)pagar último item inserido na lista.\n"
                + "Apagar item na posição (n) da lista.\n"
                + "(a)pagar itens da posição m à n da lista.\n"
                + "(L)istar todos os itens.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";
        return editarLista;
    }

    public static void apresentarFazerCompras() {
        String fazerCompras = "----------------------------------------\n"
                + "(M)arcar primeiro item por comprar.\n"
                + "(D)esmarcar primeiro item comprado.\n"
                + "Trocar estado por (n)ome.\n"
                + "Trocar estado por (p)osição.\n"
                + "(L)istar.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";
    }

    public static void apresentarListar() {
        String listar = "----------------------------------------\n"
                + "Listar (t)odos os itens.\n"
                + "Listar itens (c)omprados.\n"
                + "Listar itens (p)or comprar.\n"
                + "----------------------------------------\n";
    }

    public static void apresentarFazerContas() {
        String fazerContas = "Quanto custa a (l)ista?\n"
                + "Quanto já (g)astei?\n"
                + "Quanto custa o que (f)alta comprar?\n"
                + "Qual o preço (m)édio por item?\n"
                + "----------------------------------------\n";
    }


    public static void apresentarMenuPrincipal(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito, int nItens) {
        char op;
        do {
            System.out.println("(E)ditar lista.\n"
                    + "(F)azer compras.\n"
                    + "Fazer (c)ontas.\n"
                    + "(S)air");
            op = scanner.next().charAt(0);
            scanner.nextLine();
            switch (op) {
                case 'E':
                    apresentarEditarLista(scanner, nome, quanto, preco, feito, nItens);
                    break;
            }
        } while (op != 'S');
    }
    private static void apresentarEditarLista(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito, int nItens) {
        System.out.println(apresentarEditarLista());
        char opEditarLista = scanner.next().charAt(0);
        scanner.nextLine();
        switch (opEditarLista) {
            case 'I':
                inserirItem(scanner, nome, quanto, preco, feito, nItens);
                break;
            case 'p':
                opcaoP(scanner, nome, quanto, preco, feito, nItens);
                break;
            /*case 'A':
                (nome, quanto, preco, feito, nItens);
                break;
            case 'n':
                apagarItemNaPosicao(scanner, nome, quanto, preco, feito, nItens);
                break;
            case 'a':
                apagarItensDaPosicao(scanner, nome, quanto, preco, feito, nItens);
                break;
            case 'L':
                listarItens(nome, quanto, preco, feito, nItens);
                break;
            case 'V':
                // Voltar
                break;
            default:
                System.out.println("Opção Inválida!");*/
        }
    }

    /////////////METODO////////////
    //Insere um novo item à lista//
private static void inserirItem(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito, int nItens){

    System.out.println("Insira um item novo para a lista:");
    String novoItem = scanner.nextLine();
    nome[nItens] = novoItem;

    System.out.println("Insira o preço do item adicionado:");
    double novoPreco = scanner.nextDouble();
    preco[nItens] = novoPreco;

    System.out.println("Insira a quantidade do item adicionado:");
    int quatidade = scanner.nextInt();
    quanto[nItens] = quatidade;

    boolean comprado = false;
    feito[nItens] = comprado;

    //Adiciona +1 à variavel nItens sempre que um item novo é adicionado
    nItens++;

    System.out.println( "┏--------------------------------------┒\n"
            +   "|      Item adicionado com sucesso!    |\n"
            +   "┗--------------------------------------┛\n");
}


    ////////////////////METODO////////////////////
    //Insere um novo item numa posição escolhida//
private static void opcaoP(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito, int nItens) {
//Mostra a Lista para o usuario ter uma referência
    System.out.println("Aqui tem a Lista com todos os seus Itens:");
    System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
    for (int i = 0; i < nItens; i++) {
        char marcado = feito[i] ? 'x' : ' ';
        System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
    }

    System.out.println("Insira a posição onde deseja inserir o novo item:");
    int posicaoEscolhida = scanner.nextInt();
    scanner.nextLine();

    // Verifica se a posição inserida é válida
    if (posicaoEscolhida < 0 || posicaoEscolhida > nItens) {
        System.out.println("Posição inválida!");
    }

    // Desloca os itens para abrir espaço para o novo item na posição escolhida
    for (int i = nItens - 1; i >= posicaoEscolhida; i--) {
        nome[i+1] = nome[i];
        quanto[i+1] = quanto[i];
        preco[i+1] = preco[i];
        feito[i+1] = feito[i];
    }

    //Solicita detalhes sobre um novo item
    System.out.println("Insira o nome do novo item:");
    String nomeNovoItem = scanner.nextLine();
    nome[posicaoEscolhida] = nomeNovoItem;

    System.out.println("Insira o preço do novo item:");
    double precoNovoItem = scanner.nextDouble();
    preco[posicaoEscolhida] = precoNovoItem;

    System.out.println("Insira a quantidade do novo item:");
    double quantidadeNovoItem = scanner.nextDouble();
    quanto[posicaoEscolhida] = quantidadeNovoItem;

    boolean novoItemComprado = false;
    feito[posicaoEscolhida] = novoItemComprado;

    nItens++;

    System.out.println( "┏--------------------------------------┒\n"
            +   "|      Item adicionado com sucesso!    |\n"
            +   "┗--------------------------------------┛\n");



    System.out.println("Aqui tem a sua lista atualizada! ");
    System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
    for (int i = 0; i < nItens; i++) {
        char marcado = feito[i] ? 'x' : ' ';
        System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
    }
    System.out.println("\n---------------------------------------------------------------\n");
    }
}