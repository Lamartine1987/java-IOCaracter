package br.com.IOcaracter.java;

import java.io.*;

public class TreinoIOCaracter {
    //abrindo o teclado para escrever 3 filmes que você recomendaria e será armazenado no arquivo "filmes-e-livros.txt
    public static void criarArquivoReceberDados() throws IOException {
        //impressão no console
        PrintWriter pw = new PrintWriter(System.out);
        //mensagem que será exibida no console
        pw.println("Escreva o nome de três filmes que você recomenda: ");
        //descarregando o conteúdo do método write no console
        pw.flush();

        //padrão decorator para ler input do teclado.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //captura da linha do teclado
        String line = br.readLine();

        //classe utilizada para especificar arquivos ou diretórios
        File f = new File("filmes-e-livros.txt");

        //padrão para escrever output no arquivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do {
            //escrevendo no buffer interno a linha capturada pelo teclado
            bw.write(line);
            //pulando para a próxima linha no buffer
            bw.newLine();
            //descarregando as informações capturadas pelo teclado no arquivo
            bw.flush();
            //pegando a próxima linha do teclado
            line = br.readLine();
        }while(!(line.equalsIgnoreCase("fim")));

        //formatando a mensagem que será exibida no console com o método printf da classe PrintWrite
        pw.printf("\nO arquivo \"%s\" foi criado com sucesso!", f.getName());
        pw.printf("\nO arquivo \"%s\" possui o tamanho de '%d' bytes\n\n", f.getName(), f.length());
        //descarregando o conteúdo do método no console
        pw.flush();

        //chamando o método copiarArquivo para criar uma cópia do arquivo criado anteriormente
        copiarArquivo();

        br.close(); //fechando o fluxo de leitura
        bw.close(); //fechando o fluxo de saída para escrita no documento
        pw.close(); //fechando o fluxo de saída para o console

    }

    //Fazendo uma cópia do arquivo "filmes-e-livros.txt" e posteriormente adicionando 3 recomendações de livros.
    public static void copiarArquivo() throws IOException {
        //criando uma referência para o arquivo que será copiado.
        File f = new File("C:\\Users\\lamar\\Documents\\EntradadeDados\\IOCaracter - teste\\filmes-e-livros.txt");
        //Pegando o nome do arquivo original
        String nameArq = f.getName();

        //abrindo o arquivo que será copiado
        BufferedReader br = new BufferedReader(new FileReader(nameArq));

        //lendo as linhas do arquivo que será copiado
        String line = br.readLine();

        //formatando o nome do arquivo de copia
        String nameArqCopy = nameArq.substring(0, nameArq.indexOf(".")).concat("-copy.txt");

        //criando uma referência para o copia arquivo
        File fcopy = new File(nameArqCopy);

        //criando o arquivo copia
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));

        do {
            //pegando a linha do arquivo original e armazenando no buffer
            bw.write(line);
            //inserindo uma linha
            bw.newLine();
            //descarregando as informações capturadas no teclado no arquivo
            bw.flush();
            //depois de realizado a cópia da linha acima preenchemos a linha novamente.
            line = br.readLine();
        }while(!(line == null)); //enquanto a linha for diferente de null continuará copiando

        //formatando a mensagem de que a cópia do arquivo foi bem sucessida.
        System.out.printf("A cópia do \"%s\" foi criada com sucesso!", fcopy.getName());
        System.out.printf("\nO tamanho do novo arquivo é: '%d' bytes!\n", fcopy.length());

        //impressão no console
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("\nRecomende três livros: ");
        pw.flush(); //descarregando a mensagem no console

        //executando o método para adicionar novas informações ao arquivo que foi copiado
        adicionarInfoArquivoNovo(fcopy.getName());

        //imprimindo a mensagem de que ocorreu tudo bem a inserção das novas infomações
        pw.printf("\nOk, Tudo certo. Os livros foram inseridos com sucesso!");

        br.close(); //fechando o fluxo de entrada
        bw.close(); //fechando o fluxo de escrita no documento
        pw.close(); //fechando o fluxo de saída no console



    }

    //método para inserir as informações no arquivo que foi copiado
    public static void adicionarInfoArquivoNovo(String arquivo) throws IOException {
        //decorator para ler input do teclado
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        //decorator para escrever output no arquivo sem apagar o conteúdo que já existe
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do{
            bw.write(line); //escrevendo no buffer interno a linha capturada
            bw.newLine(); //pulando para a próxima linha no buffer
            line = br.readLine(); //pegando a próxima linha do teclado
        }while(!(line.equalsIgnoreCase("fim"))); // o while se repete até que seja digitado no teclado a palavra "fim"

        br.close();  //fechando o fluxo de entrada
        bw.close(); //fechando o fluxo de saída para escrita no documento.
    }


    public static void main(String[] args) throws IOException {
        //chamando o método que cria o arquivo inicial
        criarArquivoReceberDados();
    }
}
