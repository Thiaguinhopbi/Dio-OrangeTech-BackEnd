package thiago.edu.anatomiadasclasses4;
public class MinhaClasse {
    public static void main(String[] args) {
        String primeiroNome = "Thiago";
        String segundoNome = "de Souza";

        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);

        System.out.println (nomeCompleto);
        
    }

public static String nomeCompleto (String nome, String sobrenome){
    return "Resultado do Método " +  nome.concat(" ").concat(sobrenome);
}     

}
