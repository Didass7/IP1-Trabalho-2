import java.util.Scanner;

public class Trabalho {

    // Variáveis globais para controlar informações da lista
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

        // Chama a função para apresentar o menu principal
        apresentarMenuPrincipal(scanner, nome, quanto, preco, feito);
    }

    // MÉTODO //  MENU PRINCIPAL
    private static void apresentarMenuPrincipal(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char op;
        do {
            // Imprime o Menu principal
            System.out.println("(E)ditar lista.\n"
                    + "(F)azer compras.\n"
                    + "Fazer (c)ontas.\n"
                    + "(S)air");
            op = scanner.next().charAt(0);
            scanner.nextLine();

            // Switch para lidar com a escolha do usuario
            switch (op) {
                case 'E':
                    apresentarEditarLista(scanner, nome, quanto, preco, feito); //Métodos para apresentar os Sub-Menus
                    break;
                case 'F':
                    apresentarFazerCompras(scanner, nome, quanto, preco, feito); //Métodos para apresentar os Sub-Menus
                    break;
                case 'c':
                    apresentarFazerContas(scanner, nome, quanto, preco, feito); //Métodos para apresentar os Sub-Menus
                    break;
            }
        } while (op != 'S');
        System.out.println("┏---------------------------┒\n"
                + "|      Saiu do Programa!    |\n"
                + "┗---------------------------┛\n");

    }


    // MÉTODO //  SUB MENU: EDITAR LISTA
    private static int apresentarEditarLista(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opEditarLista;

        do {
            // Apresenta o menu de edição da lista invocando um método
            System.out.println(apresentarEditarLista());
            opEditarLista = scanner.next().charAt(0);
            scanner.nextLine();

            switch (opEditarLista) {
                case 'I':
                    // Chama a função para inserir um novo item
                    inserirItem(scanner, nome, quanto, preco, feito);
                    break;
                case 'p':
                    // Chama a função para inserir um item em uma posição específica
                    inserirItemNaposicao(scanner, nome, quanto, preco, feito);
                    break;
                case 'A':
                    // Chama a função para apagar o último item da lista
                    apagarUltimo(nome, quanto, preco, feito);
                    break;
                case 'n':
                    // Chama a função para apagar um item numa posição específica
                    apagarItemNaPosicao(scanner, nome, quanto, preco, feito);
                    break;
                case 'a':
                    // Chama a função para apagar itens de posições específicas
                    apagarItensDasPosicoes(scanner, nome, quanto, preco, feito);
                    break;
                case 'L':
                    // Chama a função para listar todos os itens da lista
                    listarItens(scanner, nome, quanto, preco, feito);
                    break;
                case 'V':
                    // Voltar
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opEditarLista != 'V');

        return nItens;
    }


    // MÉTODO //  SUB MENU: FAZER CONTAS
    private static int apresentarFazerCompras(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opFazerCompras;
        do {
            // Apresenta o menu de opções para fazer compras usando um método
            System.out.println(apresentarFazerCompras());
            opFazerCompras = scanner.next().charAt(0);
            scanner.nextLine();
            switch (opFazerCompras) {
                case 'M':
                    // Chama a função para marcar itens como por comprar
                    marcarPorcomprar(scanner, nome, quanto, preco, feito);
                    break;
                case 'D':
                    // Chama a função para desmarcar itens como comprados
                    desmarcarComprado(scanner, nome, quanto, preco, feito);
                    break;
                case 'n':
                    // Chama a função para trocar o estado de um item inserindo o seu nome
                    trocarEstadoPorNome(nome, quanto, preco, feito, scanner);
                    break;
                case 'p':
                    // Chama a função para trocar o estado de um item inserindo a sua posição
                    trocarEstadoPorPosicao(nome, quanto, preco, feito, scanner);
                    break;
                case 'L':
                    // Chama a função para listar itens
                    apresentarlistar(scanner, nome, quanto, preco, feito);
                    break;
                case 'V':
                    // Voltar
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opFazerCompras != 'V');

        return nItens;
    }


    // MÉTODO //  SUB-SUB MENU: LISTAR
    private static int apresentarlistar(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opListar;
        do {
            // Apresenta o menu de opções para listar itens
            System.out.println(apresentarlistar());
            opListar = scanner.next().charAt(0);
            scanner.nextLine();
            switch (opListar) {
                case 't':
                    // Chama a função para listar todos os itens
                    listarItens(scanner, nome, quanto, preco, feito);
                    break;
                case 'c':
                    // Chama a função para listar itens comprados
                    listarComprados(nome, quanto, preco, feito, scanner);
                    break;
                case 'p':
                    // Chama a função para listar itens por comprar
                    listarPorComprar(nome, quanto, preco, feito, scanner);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opListar != 'V');

        return nItens;
    }


    // MÉTODO //  SUB MENU: FAZER CONTAS
    private static int apresentarFazerContas(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        char opFazerContas;
        do {
            // Apresenta o menu de opções para fazer contas usando métodos
            System.out.println(apresentarFazerContas());
            opFazerContas = scanner.next().charAt(0);
            scanner.nextLine();

            switch (opFazerContas) {
                case 'l':
                    // Chama a função para calcular quanto custa a lista
                    quantoCustaLista(nome, quanto, preco, feito, scanner);
                    break;
                case 'g':
                    // Chama a função para calcular quanto já foi gasto
                    quantoJaGastou(nome, quanto, preco, feito, scanner);
                    break;
                case 'f':
                    // Chama a função para calcular quanto custa os itens selecionados como "Por Comprar"
                    quantoCustaPorComprar(nome, quanto, preco, feito, scanner);
                    break;
                case 'm':
                    // Chama a função para calcular o preço médio
                    precoMedio(nome, quanto, preco, feito, scanner);
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opFazerContas != 'V');

        return nItens;
    }


    // MÉTODO //  STRING DO SUB MENU: EDITAR LISTA
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


    // MÉTODO //  STRING DO SUB MENU: FAZER COMPRAS
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


    // MÉTODO //  STRING DO SUB-SUB MENU: LISTAR
    private static String apresentarlistar() {
        return "----------------------------------------\n"
                + "Listar (t)odos os itens.\n"
                + "Listar itens (c)omprados.\n"
                + "Listar itens (p)or comprar.\n"
                + "----------------------------------------\n";
    }


    // MÉTODO //  STRING DO SUB MENU: FAZER CONTAS
    private static String apresentarFazerContas() {
        return "----------------------------------------\n"
                + "Quanto custa a (l)ista?\n"
                + "Quanto já (g)astei?\n"
                + "Quanto custa o que (f)alta comprar?\n"
                + "Qual o preço (m)édio por item?\n"
                + "----------------------------------------\n";
    }


    ////////////////////////////////////////////
    // FUNCIONALIDADES DO PROGRAMA EM MÉTODOS //
    ////////////////////////////////////////////

    // MÉTODO //  INSERIR ITEM NOVO À LISTA
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


    // MÉTODO //  INSERIR ITEM NOVO NUMA POSIÇÃO
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
            // Desloca os itens para o novo item na posição escolhida
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


    // MÉTODO //  APAGA O ULTIMO ITEM ADICIONADO
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


    // MÉTODO //  APAGA ITEM NUMA CERTA POSIÇÃO
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


    // MÉTODO //  APAGA ITENS DE UMA POSIÇÃO À OUTRA
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


    // MÉTODO //  LISTA TODOS OS ITENS
    private static void listarItens(Scanner scanner, String[] nome, double[] quanto, double[] preco, boolean[] feito) {
        //Lista com todos os itens
        if (nItens > 0) {
            System.out.println("Aqui tem a Lista com todos os seus Itens:");
            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
            for (int i = 0; i < nItens; i++) {
                char marcado = feito[i] ? 'x' : ' ';
                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
            }
            System.out.println("\n---------------------------------------------------------------\n");
        } else {
            System.out.println("┏--------------------------------------┒\n"
                    + "|         A lista está vazia.          |\n"
                    + "┗--------------------------------------┛\n");
        }

    }


    // MÉTODO //  MARCA UM ITEM DA LISTA COMO "COMPRAR"
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


    // MÉTODO //  DESMARCA UM ITEM DA LISTA COMO "COMPRAR"
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


    // MÉTODO //  TROCA O ESTADO DO ITEM "POR COMPRAR" INSERINDO O SEU NOME
    private static void trocarEstadoPorNome(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        // Mostra a Lista
        listarItens(scanner, nome, quanto, preco, feito);

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


    // MÉTODO //  TROCA O ESTADO DO ITEM "POR COMPRAR" INSERINDO A SUA POSIÇÃO
    private static void trocarEstadoPorPosicao(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        // Mostra a Lista
        listarItens(scanner, nome, quanto, preco, feito);

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


    // MÉTODO //  LISTA TODOS OS ITENS MARCADOS COM "COMPRAR"
    private static void listarComprados(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        System.out.println("Aqui tem a Lista com todos os Itens comprados:");
        System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
        for (int i = 0; i < nItens; i++) {
            char marcado = feito[i] ? 'x' : ' ';
            if (feito[i]) {
                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
            }
        }
        System.out.println("\n---------------------------------------------------------------\n");
    }


    // MÉTODO //  LISTA TODOS OS ITENS MARCADOS COM "POR COMPRAR"
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


    // MÉTODO //  FAZ A CONTA DO PREÇO DE TODOS OS ITENS
    private static void quantoCustaLista(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        //Faz a operação para calcular o total da lista
        for (int i = 0; i < nItens; i++) {
            total += preco[i] * quanto[i];
        }
        System.out.println("┏----------------------------------------------┒\n"
                + "       O valor total da lista é:  " + total + " €.   \n"
                + "┗---------------------------------------------┛\n");
    }


    // MÉTODO //  FAZ CONTA DO PREÇO DE TODOS OS ITENS MARCADOS COM "COMPRAR"
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


    // MÉTODO //  FAZ CONTA DO PREÇO DE TODOS OS ITENS MARCADOS COM "POR COMPRAR"
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


    // MÉTODO //  FAZ A CONTA DO PRECO MEDIO DE TODOS OS ITENS DA LISTA
    private static void precoMedio(String[] nome, double[] quanto, double[] preco, boolean[] feito, Scanner scanner) {
        if (nItens > 0) {
            double precoMedio = total / nItens;

            System.out.println("┏-------------------------------------------------┒");
            System.out.printf("      O preço médio por item é: %.2f\n", precoMedio);
            System.out.println("┗-------------------------------------------------┛\n");
        } else
            System.out.println("┏-----------------------------------------------------------┒\n"
                    + "| A lista está vazia. Não é possível calcular o preço médio.|\n"
                    + "┗-----------------------------------------------------------┛\n");
    }
}
