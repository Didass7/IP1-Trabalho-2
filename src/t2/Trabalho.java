package t2;

import java.util.Scanner;

public class Trabalho {

    public static int nItens = 0;
    public static double total = 0.0;
    public static double gasto = 0.0;
    public static double falta = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamMax = 100;
        String[] nome = new String[tamMax];
        double[] quanto = new double[tamMax];
        double[] preco = new double[tamMax];
        boolean[] feito = new boolean[tamMax];


        apresentarMenuPrincipal(scanner, nome, quanto, preco, feito);
    }

    private static void apresentarMenuPrincipal(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
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
                    apresentarEditarLista(scanner, nome, quanto, preco, feito);
                    break;
                case 'F':
                    apresentarFazerCompras(scanner, nome, quanto, preco, feito);
                    break;
                case 'c':
                    apresentarFazerContas(scanner, nome, quanto, preco, feito);
                    break;
            }
        } while (op != 'S');
    }

    private static int apresentarEditarLista(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opEditarLista;
        System.out.println(apresentarEditarLista());
        opEditarLista = scanner.next().charAt(0);
        scanner.nextLine();
        switch (opEditarLista) {
            case 'I':
                inserirItem(scanner, nome, quanto, preco, feito);
                break;
            case 'p':
                inserirItemNaposicao(scanner, nome, quanto, preco, feito);
                break;
            case 'A':
                apagarUltimo(nome, quanto, preco, feito);
                break;
            case 'n':
                apagarItemNaPosicao(scanner, nome, quanto, preco, feito);
                break;
            case 'a':
                apagarItensDasPosicoes(scanner, nome, quanto, preco, feito);
                break;
            case 'L':
                listarItens(scanner, nome, quanto, preco, feito);
                break;
            case 'V':
                // Voltar
                break;
            default:
                System.out.println("Opção Inválida!");
        }
        return nItens;
    }

    private static int apresentarFazerCompras(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opFazerCompras;
        System.out.println(apresentarFazerCompras());
        opFazerCompras = scanner.next().charAt(0);
        scanner.nextLine();
        switch (opFazerCompras) {
            case 'M':
                marcarPorcomprar(scanner, nome, quanto, preco, feito);
                break;
            case 'D':
                desmarcarComprado(scanner, nome, quanto, preco, feito);
                break;
            case 'n':
                trocarEstadoPorNome(nome, quanto, preco, feito, scanner);
                break;
            case 'p':
                trocarEstadoPorPosição(nome, quanto, preco, feito, scanner);
                break;
            case 'L':
                apresentarlistar(scanner, nome, quanto, preco, feito);
                break;
            case 'V':
                // Voltar
                break;
            default:
                System.out.println("Opção Inválida!");
        }
        return nItens;
    }

    private static int apresentarlistar(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opListar;
        System.out.println(apresentarlistar());
        opListar = scanner.next().charAt(0);
        scanner.nextLine();
        switch (opListar) {
            case 't':
                listarItens(scanner, nome, quanto, preco, feito);
                break;
            case 'c':
                listarComprados(nome, quanto, preco, feito, scanner);
                break;
            case 'p':
                listarPorComprar(nome, quanto, preco, feito, scanner);
                break;
            default:
                System.out.println("Opção Inválida!");
        }
        return nItens;
    }


    private static int apresentarFazerContas(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opFazerContas;
        System.out.println(apresentarFazerContas());
        opFazerContas = scanner.next().charAt(0);
        scanner.nextLine();

        switch (opFazerContas) {
            case 'l':
                quantoCustaLista(nome, quanto, preco, feito, scanner);
                break;
            case 'g':
                quantoJaGastou(nome, quanto, preco, feito, scanner);
                break;
            case 'f':
                quantoCustaPorComprar(nome, quanto, preco, feito, scanner);
                break;
            case 'm':
                precoMedio(nome, quanto, preco, feito, scanner);
                break;
            default:
                System.out.println("Opção Inválida!");
        }
        return nItens;
    }

    private static String apresentarEditarLista() {
        return "----------------------------------------\n"
                + "(I)nserir item no fim da lista.\n"
                + "Inserir item na (p)osição n da lista.\n"
                + "(A)pagar último item inserido na lista.\n"
                + "Apagar item na posição (n) da lista.\n"
                + "(a)pagar itens da posição m à n da lista.\n"
                + "(L)istar todos os itens.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";
    }

    private static String apresentarFazerCompras() {
        return "----------------------------------------\n"
                + "(M)arcar primeiro item por comprar.\n"
                + "(D)esmarcar primeiro item comprado.\n"
                + "Trocar estado por (n)ome.\n"
                + "Trocar estado por (p)osição.\n"
                + "(L)istar.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";
    }

    private static String apresentarlistar() {
        return "----------------------------------------\n"
            + "Listar (t)odos os itens.\n"
            + "Listar itens (c)omprados.\n"
            + "Listar itens (p)or comprar.\n"
            + "----------------------------------------\n";
    }

    private static String apresentarFazerContas() {
        return "Quanto custa a (l)ista?\n"
                + "Quanto já (g)astei?\n"
                + "Quanto custa o que (f)alta comprar?\n"
                + "Qual o preço (m)édio por item?\n"
                + "----------------------------------------\n";
    }

    private static int inserirItem(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        System.out.println("Insira um item novo para a lista:");
        String novoItem = scanner.next();
        nome[nItens] = novoItem;

        System.out.println("Insira o preço do item adicionado:");
        double novoPreco = scanner.nextDouble();
        preco[nItens] = novoPreco;

        System.out.println("Insira a quantidade do item adicionado:");
        int quantidade = scanner.nextInt();
        quanto[nItens] = quantidade;

        boolean comprado = false;
        feito[nItens] = comprado;

        // Adiciona +1 à variável nItens sempre que um item novo é adicionado
        nItens++;

        System.out.println("┏--------------------------------------┒\n"
                + "|      Item adicionado com sucesso!    |\n"
                + "┗--------------------------------------┛\n");
        return nItens;
    }

    private static void inserirItemNaposicao(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        // Mostra a Lista
        listarItens(scanner, nome, quanto, preco, feito);

        System.out.println("Insira a posição onde deseja inserir o novo item:");
        int posicaoEscolhida = scanner.nextInt();
        scanner.nextLine();

        // Verifica se a posição inserida é válida
        if (posicaoEscolhida < 0 || posicaoEscolhida > nItens) {
            System.out.println("Posição inválida!");
        } else {
            // Desloca os itens para para o novo item na posição escolhida
            for (int i = nItens - 1; i >= posicaoEscolhida; i--) {
                nome[i + 1] = nome[i];
                quanto[i + 1] = quanto[i];
                preco[i + 1] = preco[i];
                feito[i + 1] = feito[i];
            }

            // Solicita info sobre um novo item
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

            System.out.println("┏--------------------------------------┒\n"
                    + "|      Item adicionado com sucesso!    |\n"
                    + "┗--------------------------------------┛\n");

            // Mostra a lista atualizada
            listarItens(scanner, nome, quanto, preco, feito);
        }
    }

    private static void apagarUltimo(String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        if (nItens > 0) {
            // Reduz o contador de itens
            nItens--;

            // Imprime mensagem informando qual item foi removido
            System.out.println("Item removido: " + nome[nItens]);

            // Limpa os arrays para o último item removido
            nome[nItens] = null;
            quanto[nItens] = 0.0;
            preco[nItens] = 0.0;
            feito[nItens] = false;
        } else {
            System.out.println("A lista está vazia. Não há itens para remover.");
        }
    }

    private static void apagarItemNaPosicao(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        // Mostra a Lista
        listarItens(scanner, nome, quanto, preco, feito);

        if (nItens > 0) {
            System.out.println("Digite a posição do item a ser apagado:");
            int posicao = scanner.nextInt();

            if (posicao >= 0 && posicao < nItens) {
                // Remove o item na posição especificada e reorganiza a lista
                for (int i = posicao; i < nItens - 1; i++) {
                    nome[i] = nome[i + 1];
                    quanto[i] = quanto[i + 1];
                    preco[i] = preco[i + 1];
                    feito[i] = feito[i + 1];
                }
                nItens--;
                System.out.println("┏------------------------------------------┒\n"
                        + "  Item na posição " + posicao + " removido com sucesso!  \n"
                        + "┗------------------------------------------┛\n");

            } else {
                System.out.println("┏--------------------------------------┒\n"
                        + "|            Posição inválida          |\n"
                        + "┗--------------------------------------┛\n");
            }
        } else {
            System.out.println("┏--------------------------------------┒\n"
                    + "|  A lista está vazia! Nada a remover. |\n"
                    + "┗--------------------------------------┛\n");
        }
    }

    private static void apagarItensDasPosicoes(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        // Mostra a Lista
        listarItens(scanner, nome, quanto, preco, feito);

        if (nItens > 0) {
            System.out.println("Digite a posição inicial (m) dos itens a serem apagados:");
            int pInicial = scanner.nextInt();
            System.out.println("Digite a posição final (n) dos itens a serem apagados:");
            int pFinal = scanner.nextInt();

            //Verifica se as posições são válidas e calcula as posições que foram removidas
            if (pInicial >= 0 && pFinal < nItens && pInicial <= pFinal) {
                int qRemovidos = pFinal - pInicial + 1;

                //Remove os itens da lista e desloca os outros para preencher os espaços vazios
                for (int i = 0; i < nItens - qRemovidos; i++) {
                    if (i < pInicial) {
                        continue;
                    }
                    nome[i] = nome[i + qRemovidos];
                    quanto[i] = quanto[i + qRemovidos];
                    preco[i] = preco[i + qRemovidos];
                    feito[i] = feito[i + qRemovidos];
                }
                //Atualiza o número de itens
                nItens -= qRemovidos;

                System.out.println("┏--------------------------------------------------┒\n"
                        + "  Itens da posição " + pInicial + " à posição " + pFinal + " foram removidos.  \n"
                        + "┗--------------------------------------------------┛\n");

            } else {
                System.out.println("┏--------------------------------------┒\n"
                        + "|         Posições inválidas.          |\n"
                        + "┗--------------------------------------┛\n");
            }
        } else {
            System.out.println("┏--------------------------------------┒\n"
                    + "|         A lista está vazia.          |\n"
                    + "┗--------------------------------------┛\n");
        }
    }

    private static void listarItens(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        //Lista com todos os itens
        System.out.println("Aqui tem a Lista com todos os seus Itens:");
        System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
        for (int i = 0; i < nItens; i++) {
            char marcado = feito[i] ? 'x' : ' ';
            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
        }
        System.out.println("\n---------------------------------------------------------------\n");
    }

    private static void marcarPorcomprar(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        //Verifica se há itens na lista
        if (nItens > 0) {
            //Percorre a lista de itens e verifica se o item já está marcado como comprado
            for (int i = 0; i < nItens; i++) {
                if (!feito[i]) {
                    feito[i] = true;
                    System.out.println("┏--------------------------------------------------┒\n"
                            + "    " + nome[i] + " está marcado como comprado!  \n"
                            + "┗--------------------------------------------------┛\n");
                    break;
                }
            }
        } else {
            System.out.println("┏--------------------------------------┒\n"
                    + "|          A lista está vazia!         |\n"
                    + "┗--------------------------------------┛\n");
        }
    }

    private static void desmarcarComprado(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        boolean primeiroItemMarcado = false;
        for (int i = 0; i < nItens; i++) {

            //Verifica se o item está marcado como comprado
            if (feito[i]) {
                feito[i] = false;

                System.out.println("┏----------------------------------------┒\n"
                        + "        " + nome[i] + " foi desmarcado.  \n"
                        + "┗----------------------------------------┛\n");
                primeiroItemMarcado = true;
                break;
            }
            if (!primeiroItemMarcado) {
                System.out.println("┏------------------------------------------┒\n"
                        + "|  Nenhum item está marcado como comprado! |\n"
                        + "┗------------------------------------------┛\n");
            }
        }
    }

    private static void trocarEstadoPorNome(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        System.out.println("Aqui tem a Lista com todos os seus Itens:");
        System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
        for (int i = 0; i < nItens; i++) {
            char marcado = feito[i] ? 'x' : ' ';
            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
        }

        System.out.println("Insira o nome do item para trocar o estado");
        String nomeItem = scanner.next();

        //faz um ciclo para encontrar o item correspondente ao nome fornecido
        for (int i = 0; i < nItens; i++) {
            if (nome[i].equalsIgnoreCase(nomeItem)) {
                //altera o estado do item entre "comprado" e "por comprar"
                feito[i] = !feito[i];
                String estado = feito[i] ? "comprado" : "por comprar";
                System.out.println("┏--------------------------------------------------┒\n"
                        + "     " + nome[i] + " está agora " + estado + "!\n"
                        + "┗--------------------------------------------------┛\n");
                break;
            }
        }
    }

    private static void trocarEstadoPorPosição(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        System.out.println("Aqui tem a Lista com todos os seus Itens:");
        System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
        for (int i = 0; i < nItens; i++) {
            char marcado = feito[i] ? 'x' : ' ';
            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
        }

        System.out.println("Qual é a posição do item a ser marcado/desmarcado? ");
        int posicao = scanner.nextInt();

        // Verifica se a posição fornecida é válida
        if (posicao < 0 && posicao >= nItens) {
            System.out.println("┏------------------------------------------┒\n"
                    + "|            Posição Inválida!             |\n"
                    + "┗------------------------------------------┛\n");
        } else {

            // Marca ou desmarca o item na posição especificada
            feito[posicao] = !feito[posicao];
            String estado = feito[posicao] ? "comprado" : "por comprar";
            System.out.println("┏-----------------------------------------┒\n"
                    + "  " + nome[posicao] + " está agora " + estado + "!\n"
                    + "┗-----------------------------------------┛\n");
        }
    }
    private static void listarComprados(String[] nome, double[] quanto, double[] preco, boolean[] feito, int nItens, Scanner scanner){
        
    }

    private static void listarPorComprar(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        System.out.println("Aqui tem a Lista com todos os Itens por comprar:");
        System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
        for (int i = 0; i < nItens; i++) {
            char marcado = feito[i] ? 'x' : ' ';
            if (!feito[i]) {
                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
            }
        }
        System.out.println("\n---------------------------------------------------------------\n");
    }

    private static void quantoCustaLista(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
//Faz a operação para calcular o total da lista
        for(int i = 0; i < nItens; i++){
            total += preco[i]*quanto[i];
        }
        System.out.println("┏----------------------------------------------┒\n"
                + "       O valor total da lista é:  " + total + " €.   \n"
                + "┗---------------------------------------------┛\n");
    }

    private static void quantoJaGastou(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {

        for (int i = 0; i < nItens; i++) {
            if (feito[i]) {
                gasto += quanto[i] * preco[i];
            }
        }
        System.out.println("┏----------------------------------------------┒");
        System.out.printf("        O valor total gasto é: %.2f€\n", gasto);
        System.out.println("┗----------------------------------------------┛\n");
    }

    private static void quantoCustaPorComprar(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {

        //Calcula o valor total do que falta comprar somando a quantidade multiplicada pelo preço de cada item não marcado como comprado
        for (int i = 0; i < nItens; i++) {
            if (!feito[i]) {
                falta += quanto[i] * preco[i];
            }
        }
        System.out.println("┏------------------------------------------------------┒");
        System.out.printf("   O valor total do que falta comprar é: %.2f\n", falta);
        System.out.println("┗------------------------------------------------------┛\n");
    }

    private static void precoMedio(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        if (nItens > 0) {
                double precoMedio = total / nItens;

                System.out.println("┏-------------------------------------------------┒");
                System.out.printf("      O preço médio por item é: %.2f\n", precoMedio);
                System.out.println("┗-------------------------------------------------┛\n");
            }
        else
            System.out.println("┏-----------------------------------------------------------┒\n"
                        + "| A lista está vazia. Não é possível calcular o preço médio.|\n"
                        + "┗-----------------------------------------------------------┛\n");
        }
    }
