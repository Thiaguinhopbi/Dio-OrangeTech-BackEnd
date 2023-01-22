import java.util.*;

public class Exercicio2 {
    /*
    Crie uma classe LinguagemFavorita que possua os atributos
    nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
    3 linguagens e faça um programa que ordene esse conjunto
    por:

    Ordem de Inserção
    Ordem Natural (nome)
    IDE
    Ano de criação e nome
    Nome, ano de criacao e IDE
    Ao final, exiba as linguagens no console, um abaixo da outra.
     */

    public static void main(String[] args) {
        System.out.println("Crie um Conjunto com 3 Linguagens: ");
        System.out.println();

        Set<LinguagemFavorita>linguagem0 = new HashSet<>();
        linguagem0.add(new LinguagemFavorita("Java", 1991, "NetBeans"));
        linguagem0.add(new LinguagemFavorita("Phyton", 1991, "Pycharm"));
        linguagem0.add(new LinguagemFavorita("C#", 1999, "Visual Studio"));

        System.out.println("-- \tOrdem de Inserção\t --");
        Set<LinguagemFavorita>linguagem= new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Java", 1991, "NetBeans"),
                        new LinguagemFavorita("Python", 1991, "Picharm"),
                        new LinguagemFavorita("C#", 1999, "Visual Studio")
                )
        );

        for(LinguagemFavorita lang : linguagem){
            System.out.println(lang.getNome() + " - " + lang.getAnoDeCriacao() + " - " +
                    lang.getIde());
        }
        System.out.println();

        System.out.println("-- \tOrdem Natural (Nome)\t --");
        Set<LinguagemFavorita>linguagem1 = new TreeSet<LinguagemFavorita>(linguagem);
        for(LinguagemFavorita lang : linguagem1){
            System.out.println(lang.getNome() + " - " + lang.getAnoDeCriacao() + " - " +
                    lang.getIde());
        }
        System.out.println();

        System.out.println("-- \tOrdem Natural (IDE)\t --");
        Set<LinguagemFavorita>linguagem2 = new TreeSet<LinguagemFavorita>(new ComparatorIde());
        linguagem2.addAll(linguagem);
        for(LinguagemFavorita language : linguagem) {
            System.out.println(language.nome + " - " + language.anoDeCriacao + " - " + language.ide);


        }
        System.out.println();

        System.out.println("-- \tOrdem (Ano de criação e IDE)\t --");
        Set<LinguagemFavorita>linguagem3 = new TreeSet<LinguagemFavorita>(new ComparatorAnoIde());
        linguagem3.addAll(linguagem1);
        for (LinguagemFavorita ling : linguagem3){
            System.out.println(ling.nome + " - " + ling.anoDeCriacao + " - " + ling.ide);
        }
        System.out.println();

        System.out.println(" -- \tOrdem (Nome, Ano e IDE)\t --");
        Set<LinguagemFavorita>linguagem4 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoIde());
        linguagem4.addAll(linguagem1);

        for(LinguagemFavorita langs : linguagem4){
            System.out.println(langs.nome + " - " + langs.anoDeCriacao + " - " + langs.ide);

        }


    }



}


class LinguagemFavorita implements Comparable <LinguagemFavorita> {
    public String nome;
    public int anoDeCriacao;
    public String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return anoDeCriacao == that.anoDeCriacao && nome.equals(that.nome) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita lang) {
        int nome = CharSequence.compare(this.getNome(), lang.getNome());
        if(nome != 0) return nome;
        return nome ;
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lang1, LinguagemFavorita lang2) {
        return lang1.ide.compareToIgnoreCase(lang1.getIde());
    }
}

class ComparatorAnoIde implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita lang1, LinguagemFavorita lang2) {
        int anoDeCriacao  = Integer.compare(lang1.anoDeCriacao, lang2.anoDeCriacao);
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lang1.nome.compareToIgnoreCase(lang2.nome);
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita lang1, LinguagemFavorita lang2) {
        int nome = lang1.nome.compareToIgnoreCase(lang2.nome);
        int anoDeCriacao = Integer.compare(lang1.anoDeCriacao, lang2.anoDeCriacao);
        if(nome != 0) return nome;
        if(anoDeCriacao != 0) return anoDeCriacao;
        return lang1.ide.compareToIgnoreCase(lang1.ide);
    }
}



