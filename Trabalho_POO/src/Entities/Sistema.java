package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

//Tornar Editavel, Palestra, Participante e Local
public class Sistema {

    private ArrayList<Participante> participantes;
    private ArrayList<Palestrante> palestrantes;
    private ArrayList<Palestra> palestras;
    private ArrayList<Local> locais;
    private ArrayList<Apresentacao> apresentacoes;
    private ArrayList<Inscricao> inscricoes;
    private ArrayList<Alocacao> alocacoes;

    public Sistema() {
        this.participantes = new ArrayList<>();
        this.palestrantes = new ArrayList<>();
        this.palestras = new ArrayList<>();
        this.locais = new ArrayList<>();
        this.apresentacoes = new ArrayList<>();
        this.inscricoes = new ArrayList<>();
        this.alocacoes = new ArrayList<>();
    }

    public ArrayList<Inscricao> getInscricaos() {
        return inscricoes;
    }

    public void setInscricaos(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public ArrayList<Alocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(ArrayList<Alocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Palestrante> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(ArrayList<Palestrante> palestrantes) {
        this.palestrantes = palestrantes;
    }

    public ArrayList<Palestra> getPalestras() {
        return palestras;
    }

    public void setPalestras(ArrayList<Palestra> palestras) {
        this.palestras = palestras;
    }

    public ArrayList<Local> getLocais() {
        return locais;
    }

    public void setLocais(ArrayList<Local> locais) {
        this.locais = locais;
    }

    public ArrayList<Apresentacao> getPalestrante_palestras() {
        return apresentacoes;
    }

    public void setPalestrante_palestras(ArrayList<Apresentacao> apresentacoes) {
        this.apresentacoes = apresentacoes;
    }

    public ArrayList<Inscricao> getParticipante_palestras() {
        return inscricoes;
    }

    public void setParticipante_palestras(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public void AddParticipante(Scanner sc) throws Exception {
        String Email = getString(sc, "Insira o E-mail: ");
        if (participantes.stream().filter(a -> a.getEmail().equalsIgnoreCase(Email))
                .collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
            String Nome = getString(sc, "Insira o Nome: ");
            ;
            String Endereco = getString(sc, "Insira o seu Endereço: ");
            ArrayList<String> Telefone = new ArrayList<>();
            while (true) {
                String tmp = getString(sc, ("Insira o " + (Telefone.size() + 1) + "º Telefone: "));
                Telefone.add(tmp);
                Integer stop;
                while (true) {
                    stop = getInteger(sc, "Gostaria de inserir mais um Telefone(1 - Sim, 2 - Não): ");
                    if (stop == 1 || stop == 2) {
                        break;
                    } else {
                        System.out.println("Valor inválido, insira novamente");
                    }
                }
                if (stop == 2) {
                    break;
                }
            }

            int size = participantes.size();
            Participante participante = new Participante(Nome, Endereco, Email, size);
            participante.setTelefone(Telefone);

            participantes.add(participante);
            System.out.println("\nAdição feita com sucesso\n");
        } else {
            throw new Exception("Email já utilizado");
        }
    }

    public void RemoveParticipante(Scanner sc) throws Exception {
        if (!participantes.isEmpty()) {
            System.out.println("Participantes: ");
            for (Participante participante : participantes) {
                System.out.println("\nNúmero: " + participantes.indexOf(participante));
                System.out.println("Código do Participante: " + participante.getCodigo());
                System.out.println("Nome: " + participante.getNome());
                System.out.println("Email: " + participante.getEmail());
                System.out.println("Endereço: " + participante.getEndereco() + "\n");
            }
            while (true) {
                Integer index_participante = getInteger(sc,
                        "Insira o Número do participante a ser removido ou -1 para cancelar operação: ");
                if (index_participante >= 0 && index_participante < participantes.size()) {
                    Participante tmp = participantes.get(index_participante);
                    inscricoes.removeIf(a -> a.getParticipante().equals(tmp));
                    participantes.remove(tmp);
                    System.out.println("\nRemoção feita com sucesso\n");
                    break;
                } else if (index_participante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum participante cadastrado");
        }
    }

    public void EditParticipante(Scanner sc) throws Exception {
        if (!participantes.isEmpty()) {
            System.out.println("Participantes: ");
            for (Participante participante : participantes) {
                System.out.println("\nNúmero: " + participantes.indexOf(participante));
                System.out.println("Código do Participante: " + participante.getCodigo());
                System.out.println("Nome: " + participante.getNome());
                System.out.println("Email: " + participante.getEmail());
                System.out.println("Endereço: " + participante.getEndereco() + "\n");
            }
            while (true) {
                Integer index_participante = getInteger(sc,
                        "Insira o Número do participante a ser editado ou -1 para cancelar operação: ");
                if (index_participante >= 0 && index_participante < participantes.size()) {
                    Participante tmp = participantes.get(index_participante);

                    String Email = getString(sc, "Insira o E-mail: ");
                    if (participantes.stream().filter(a -> a.getEmail().equalsIgnoreCase(Email))
                            .collect(Collectors.toCollection(ArrayList::new)).isEmpty()
                            || tmp.getEmail().equalsIgnoreCase(Email)) {
                        String Nome = getString(sc, "Insira o Nome: ");
                        ;
                        String Endereco = getString(sc, "Insira o seu Endereço: ");
                        ArrayList<String> Telefone = new ArrayList<>();
                        while (true) {
                            String tmp_telefone = getString(sc, ("Insira o " + (Telefone.size() + 1) + "º Telefone: "));
                            Telefone.add(tmp_telefone);
                            Integer stop;
                            while (true) {
                                stop = getInteger(sc, "Gostaria de inserir mais um Telefone(1 - Sim, 2 - Não): ");
                                if (stop == 1 || stop == 2) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido, insira novamente");
                                }
                            }
                            if (stop == 2) {
                                break;
                            }
                        }
                        tmp.setEmail(Email);
                        tmp.setNome(Nome);
                        tmp.setEndereco(Endereco);
                        tmp.setTelefone(Telefone);
                        System.out.println("\nEdição feita com sucesso\n");
                        break;
                    } else {
                        throw new Exception("Email já utilizado");
                    }
                } else if (index_participante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum participante cadastrado");
        }
    }

    public void AddPalestrante(Scanner sc) throws Exception {
        String Email = getString(sc, "Insira o E-mail: ");
        if (palestrantes.stream().filter(a -> a.getEmail().equalsIgnoreCase(Email))
                .collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
            String Nome = getString(sc, "Insira o Nome: ");
            ;
            String Endereco = getString(sc, "Insira o seu Endereço: ");
            String Especialidade = getString(sc, "Insira a especialidade do palestrante: ");
            ArrayList<String> Telefone = new ArrayList<>();
            while (true) {
                String tmp = getString(sc, ("Insira o " + (Telefone.size() + 1) + "º Telefone: "));
                Telefone.add(tmp);
                Integer stop;
                while (true) {
                    stop = getInteger(sc, "Gostaria de inserir mais um Telefone(1 - Sim, 2 - Não): ");
                    if (stop == 1 || stop == 2) {
                        break;
                    } else {
                        System.out.println("Valor inválido, insira novamente");
                    }
                }
                if (stop == 2) {
                    break;
                }
            }

            Palestrante palestrante = new Palestrante(Nome, Endereco, Email, Especialidade);
            palestrante.setTelefone(Telefone);
            palestrantes.add(palestrante);
            System.out.println("\nAdição feita com sucesso\n");
        } else {
            throw new Exception("Email já utilizado");
        }
    }

    public void RemovePalestrante(Scanner sc) throws Exception {
        if (!palestrantes.isEmpty()) {
            System.out.println("Palestrantes: ");
            for (Palestrante palestrante : palestrantes) {
                System.out.println("\nNúmero: " + palestrantes.indexOf(palestrante));
                System.out.println("Nome: " + palestrante.getNome());
                System.out.println("Email: " + palestrante.getEmail());
                System.out.println("Endereço: " + palestrante.getEndereco());
                System.out.println("Especialidade: " + palestrante.getEspecialidade() + "\n");
            }
            while (true) {
                Integer index_palestrante = getInteger(sc,
                        "Insira o Número do participante a ser removido ou -1 para cancelar operação: ");
                if (index_palestrante >= 0 && index_palestrante < palestrantes.size()) {
                    Palestrante tmp = palestrantes.get(index_palestrante);
                    apresentacoes.removeIf(a -> a.getPalestrante().equals(tmp));
                    palestrantes.remove(tmp);
                    System.out.println("\nRemoção feita com sucesso\n");
                    break;
                } else if (index_palestrante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum palestrante cadastrado");
        }
    }

    public void EditPalestrante(Scanner sc) throws Exception {
        if (!palestrantes.isEmpty()) {
            System.out.println("Palestrantes: ");
            for (Palestrante palestrante : palestrantes) {
                System.out.println("\nNúmero: " + palestrantes.indexOf(palestrante));
                System.out.println("Nome: " + palestrante.getNome());
                System.out.println("Email: " + palestrante.getEmail());
                System.out.println("Endereço: " + palestrante.getEndereco());
                System.out.println("Especialidade: " + palestrante.getEspecialidade() + "\n");
            }
            while (true) {
                Integer index_palestrante = getInteger(sc,
                        "Insira o Número do palestrante a ser editado ou -1 para cancelar operação: ");
                if (index_palestrante >= 0 && index_palestrante < palestrantes.size()) {
                    Palestrante tmp = palestrantes.get(index_palestrante);

                    String Email = getString(sc, "Insira o E-mail: ");
                    if (palestrantes.stream().filter(a -> a.getEmail().equalsIgnoreCase(Email))
                            .collect(Collectors.toCollection(ArrayList::new)).isEmpty()
                            || tmp.getEmail().equalsIgnoreCase(Email)) {
                        String Nome = getString(sc, "Insira o Nome: ");
                        ;
                        String Endereco = getString(sc, "Insira o seu Endereço: ");
                        String Especialidade = getString(sc, "Insira a especialidade do palestrante: ");
                        ArrayList<String> Telefone = new ArrayList<>();
                        while (true) {
                            String tmp_telefone = getString(sc, ("Insira o " + (Telefone.size() + 1) + "º Telefone: "));
                            Telefone.add(tmp_telefone);
                            Integer stop;
                            while (true) {
                                stop = getInteger(sc, "Gostaria de inserir mais um Telefone(1 - Sim, 2 - Não): ");
                                if (stop == 1 || stop == 2) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido, insira novamente");
                                }
                            }
                            if (stop == 2) {
                                break;
                            }
                        }
                        tmp.setEmail(Email);
                        tmp.setNome(Nome);
                        tmp.setEndereco(Endereco);
                        tmp.setEspecialidade(Especialidade);
                        tmp.setTelefone(Telefone);
                        System.out.println("\nEdição feita com sucesso\n");
                        break;
                    } else {
                        throw new Exception("Email inválido");
                    }
                } else if (index_palestrante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum palestrante cadastrado");
        }
    }

    public void Inscricao(Scanner sc) throws Exception {
        if (!participantes.isEmpty() && !palestras.isEmpty()) {
            System.out.println("Participantes: ");
            for (Participante participante : participantes) {
                System.out.println("\nNúmero: " + participantes.indexOf(participante));
                System.out.println("Código do Participante: " + participante.getCodigo());
                System.out.println("Nome: " + participante.getNome());
                System.out.println("Email: " + participante.getEmail());
                System.out.println("Endereço: " + participante.getEndereco() + "\n");
            }
            while (true) {
                Integer index_participante = getInteger(sc,
                        "Insira o Número do participante a ser inscrito ou -1 para cancelar operação: ");
                if (index_participante >= 0 && index_participante < participantes.size()) {
                    Participante participante = participantes.get(index_participante);
                    for (Palestra palestra : palestras) {
                        System.out.println("Palestras: ");
                        System.out.println("\nNúmero: " + palestras.indexOf(palestra));
                        System.out.println("Nome: " + palestra.getNome());
                        System.out.println("Quantidade de Vagas" + palestra.getVagas());
                        System.out.println("Início: " + palestra.getInicio());
                        System.out.println("Fim: " + palestra.getFim());
                        System.out.println("Descrição: " + palestra.getDescricao() + "\n");
                    }
                    while (true) {
                        Integer index_palestra = getInteger(sc,
                                "Insira o Número da palestra ou -1 para cancelar operação: ");
                        if (index_palestra >= 0 && index_palestra < palestras.size()) {
                            Palestra palestra = palestras.get(index_palestra);
                            if (inscricoes.stream().filter(a -> a.getPalestra().equals(palestra))
                                    .collect(Collectors.toCollection(ArrayList::new)).size() < palestra.getVagas()) {
                                Inscricao inscricao = new Inscricao(participante, palestra);
                                if (inscricoes.stream().filter(a -> a.getPalestra().equals(palestra) && a.getParticipante().equals(participante)).collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
                                    inscricoes.add(inscricao);
                                    System.out.println("\nInscrição feita com sucesso\n");
                                } else {
                                    System.out.println("Esse participante ja esta inscrito nessa palestra");
                                }
                            }
                            else{
                                System.out.println("A palestra não possui mais vagas");
                            }
                            return;
                        } else if (index_palestra == -1) {
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente");
                        }
                    }
                    break;
                } else if (index_participante == -1) {
                    return;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else if (participantes.isEmpty()) {
            throw new Exception("Nenhum participante cadastrado");
        } else {
            throw new Exception("Nenhuma palestra cadastrada");
        }
    }

    public void RemoverInscricao(Scanner sc) throws Exception {
        if (!participantes.isEmpty() && !inscricoes.isEmpty()) {
            System.out.println("Participantes: ");
            for (Participante participante : participantes) {
                System.out.println("\nNúmero: " + participantes.indexOf(participante));
                System.out.println("Código do Participante: " + participante.getCodigo());
                System.out.println("Nome: " + participante.getNome());
                System.out.println("Email: " + participante.getEmail());
                System.out.println("Endereço: " + participante.getEndereco() + "\n");
            }
            while (true) {
                Integer index_participante = getInteger(sc,
                        "Insira o Número do participante ou -1 para cancelar operação: ");
                if (index_participante >= 0 && index_participante < participantes.size()) {
                    Participante participante = participantes.get(index_participante);
                    ArrayList<Inscricao> tmp_inscricoes = inscricoes.stream()
                            .filter(a -> a.getParticipante().equals(participante))
                            .collect(Collectors.toCollection(ArrayList::new));
                    if (!tmp_inscricoes.isEmpty()) {
                        for (Inscricao inscricao : tmp_inscricoes) {
                            System.out.println("Inscrições: ");
                            System.out.println("\nNúmero: " + inscricoes.indexOf(inscricao));
                            System.out.println("Nome: " + inscricao.getPalestra().getNome());
                            System.out.println("Descrição: " + inscricao.getPalestra().getDescricao());
                            System.out.println("Capacidade de vagas: " + inscricao.getPalestra().getVagas());
                            System.out.println("Início: " + inscricao.getPalestra().getInicio());
                            System.out.println("Fim: " + inscricao.getPalestra().getFim());
                            Apresentacao apresentacao = apresentacoes.stream()
                                    .filter(a -> a.getPalestra().equals(inscricao.getPalestra())).findAny()
                                    .orElse(null);
                            if (apresentacao != null) {
                                System.out.println("Palestrante responsável: ");
                                System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                                System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                            }
                            Alocacao alocacao = alocacoes.stream()
                                    .filter(a -> a.getPalestra().equals(inscricao.getPalestra())).findAny()
                                    .orElse(null);
                            if (alocacao != null) {
                                System.out.println("Local da palestra: ");
                                System.out.println(alocacao.getLocal().getNome());
                            }
                            System.out.println("\n");
                        }
                        while(true){
                            Integer index_inscricao = getInteger(sc, "Insira o número da inscrição a ser removida ou -1 para cancelar a operação: ");
                            if(index_inscricao >= 0 && index_inscricao < tmp_inscricoes.size()){
                                Inscricao inscricao = inscricoes.get(index_inscricao);
                                inscricoes.remove(inscricao);
                                System.out.println("\nRemoção feita com sucesso\n");
                                break;
                            }
                            else if(index_inscricao == -1){
                                break;
                            }
                            else{
                                System.out.println("Valor inválido");

                            }
                        }
                        break;
                    } else {
                        System.out.println("Esse participante nao possui inscricoes");
                        break;
                    }
                } else if (index_participante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido");
                }
            }
        } else if (participantes.isEmpty()) {
            throw new Exception("Nenhum participante cadastrado");
        } else {
            throw new Exception("Nenhuma inscrição cadastrada");
        }
    }

    public void AddLocal(Scanner sc) throws Exception {
        String Nome = getString(sc, "Insira o nome: ");
        if (locais.stream().filter(a -> a.getNome().equalsIgnoreCase(Nome))
                .collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
            Integer Capacidade = getInteger(sc, "Insira a capacidade: ");
            if (Capacidade > 0) {
                ArrayList<String> Recursos = new ArrayList<>();
                while (true) {
                    String tmp_recurso = getString(sc, ("Insira o " + (Recursos.size() + 1) + "º Recurso: "));
                    Recursos.add(tmp_recurso);
                    Integer stop;
                    while (true) {
                        stop = getInteger(sc, "Gostaria de inserir mais um Recurso(1 - Sim, 2 - Não): ");
                        if (stop == 1 || stop == 2) {
                            break;
                        } else {
                            System.out.println("Valor inválido, insira novamente");
                        }
                    }
                    if (stop == 2) {
                        break;
                    }
                }
                Local local = new Local(Nome, Capacidade);
                local.setRecursos(Recursos);
                locais.add(local);
                System.out.println("\nAdição feita com sucesso com sucesso\n");
            } else {
                throw new Exception("Valor inválido");
            }
        } else {
            throw new Exception("Nome inválido");
        }
    }

    public void RemoveLocal(Scanner sc) throws Exception {
        if (!locais.isEmpty()) {
            System.out.println("Locais: ");
            for (Local local : locais) {
                System.out.println("\nNúmero: " + locais.indexOf(local));
                System.out.println("Nome: " + local.getNome());
                System.out.println("Capacidade: " + local.getCapacidade());
                if (!local.getRecursos().isEmpty()) {
                    System.out.println("Recursos: ");
                    for (String obj : local.getRecursos()) {
                        System.out.println(obj);
                    }
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_local = getInteger(sc,
                        "Insira o Número do local a ser removido ou -1 para cancelar operação: ");
                if (index_local >= 0 && index_local < locais.size()) {
                    Local tmp = locais.get(index_local);
                    alocacoes.removeIf(a -> a.getLocal().equals(tmp));
                    locais.remove(tmp);
                    System.out.println("\nRemoção feita com sucesso\n");
                    return;
                } else if (index_local == -1) {
                    return;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum local cadastrado");
        }
    }

    public void EditLocal(Scanner sc) throws Exception {
        if (!locais.isEmpty()) {
            System.out.println("Locais: ");
            for (Local local : locais) {
                System.out.println("\nNúmero: " + locais.indexOf(local));
                System.out.println("Nome: " + local.getNome());
                System.out.println("Capacidade: " + local.getCapacidade());
                if (!local.getRecursos().isEmpty()) {
                    System.out.println("Recursos: ");
                    for (String obj : local.getRecursos()) {
                        System.out.println(obj);
                    }
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_local = getInteger(sc,
                        "Insira o Número do local a ser removido ou -1 para cancelar operação: ");
                if (index_local >= 0 && index_local < locais.size()) {
                    Local tmp = locais.get(index_local);
                    String Nome = getString(sc, "Insira o nome: ");
                    if (locais.stream().filter(a -> a.getNome().equalsIgnoreCase(Nome))
                            .collect(Collectors.toCollection(ArrayList::new)).isEmpty() || tmp.getNome().equals(Nome)) {
                        ArrayList<String> Recursos = new ArrayList<>();
                        while (true) {
                            String tmp_recurso = getString(sc, ("Insira o " + (Recursos.size() + 1) + "º Recurso: "));
                            Recursos.add(tmp_recurso);
                            Integer stop;
                            while (true) {
                                stop = getInteger(sc, "Gostaria de inserir mais um Recurso(1 - Sim, 2 - Não): ");
                                if (stop == 1 || stop == 2) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido, insira novamente");
                                }
                            }
                            if (stop == 2) {
                                break;
                            }
                        }
                        tmp.setNome(Nome);
                        tmp.setRecursos(Recursos);
                        System.out.println("\nEdição feita com sucesso\n");
                        return;
                    } else {
                        throw new Exception("Nome inválido");
                    }
                } else if (index_local == -1) {
                    return;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhum local cadastrado");
        }
    }

    public void AddPalestra(Scanner sc) throws Exception {
        String tmp_data = getString(sc, "Insira a data(yyyy-MM-dd): ");
        // HH:mm
        String hora_inicio = getString(sc, "Insira a hora de início(HH:mm): ");
        String hora_fim = getString(sc, "Insira a hora de finalização(HH:mm): ");
        // yyyy-MM-ddTHH:mm
        String tmp_LocalDateTime = tmp_data + "T" + hora_inicio;
        LocalDateTime inicio = LocalDateTime.parse(tmp_LocalDateTime);
        tmp_LocalDateTime = tmp_data + "T" + hora_fim;
        LocalDateTime fim = LocalDateTime.parse(tmp_LocalDateTime);
        if (inicio.isBefore((fim))) {
            String Nome = getString(sc, "Insira o nome: ");
            String Descricao = getString(sc, "Insira a Descrição: ");
            Integer vagas = getInteger(sc, "Insira a quantidade de vagas: ");
            if (vagas > 0) {
                Integer tmp_boolean = getInteger(sc, "A palestra emite certificado ?(1 - Sim, 2 - Não): ");
                if (tmp_boolean == 1 || tmp_boolean == 2) {
                    boolean EmiteCertificado;
                    if (tmp_boolean == 1) {
                        EmiteCertificado = true;
                    } else {
                        EmiteCertificado = false;
                    }
                    Palestra palestra = new Palestra(Nome, Descricao, inicio, fim, vagas, EmiteCertificado);
                    palestras.add(palestra);

                    Integer choice;
                    while (true) {
                        choice = getInteger(sc, "Adicionar local a palestra ?(1 - Sim, 2 - Não): ");
                        if (choice == 1) {
                            ArrayList<Local> tmp_Locais = locais.stream().filter(a -> a.getCapacidade()>=vagas).collect(Collectors.toCollection(ArrayList::new));
                            if (!tmp_Locais.isEmpty()) {
                                System.out.println("Locais: ");
                                for (Local local : tmp_Locais) {
                                    System.out.println("\nNúmero: " + tmp_Locais.indexOf(local));
                                    System.out.println("Nome: " + local.getNome());
                                    System.out.println("Capacidade: " + local.getCapacidade());
                                    if (!local.getRecursos().isEmpty()) {
                                        System.out.println("Recursos: ");
                                        for (String obj : local.getRecursos()) {
                                            System.out.println(obj);
                                        }
                                    }
                                    ArrayList<Alocacao> tmp_alocacoes = alocacoes.stream().filter(
                                                    a -> a.getLocal().equals(local) || a.getLocal().getCapacidade() >= vagas)
                                            .collect(Collectors.toCollection(ArrayList::new));
                                    if (!tmp_alocacoes.isEmpty()) {
                                        System.out.println("Palestras do local: ");
                                        for (Alocacao alocacao : tmp_alocacoes) {
                                            System.out.println("Nome: " + alocacao.getPalestra().getNome());
                                            System.out.println("Descrição: " + alocacao.getPalestra().getDescricao());
                                            System.out.println("Início: " + alocacao.getPalestra().getInicio());
                                            System.out.println("Fim: " + alocacao.getPalestra().getFim());
                                        }
                                    } else {
                                        System.out.println("Esse local não possui eventos");
                                    }
                                    System.out.println("\n");
                                }
                                while (true) {
                                    Integer index_local = getInteger(sc,
                                            "Insira o Número do local a ser atrelado ou -1 para cancelar operação: ");
                                    if (index_local >= 0 && index_local < tmp_Locais.size()) {
                                        Local local = tmp_Locais.get(index_local);
                                        ArrayList<Alocacao> tmp_alocacoes = alocacoes.stream()
                                                .filter(a -> a.getLocal().equals(local))
                                                .collect(Collectors.toCollection(ArrayList::new));
                                        if (tmp_alocacoes.isEmpty() || tmp_alocacoes.stream()
                                                .filter(a -> (a.getPalestra().getInicio().isBefore(inicio)
                                                        && a.getPalestra().getFim().isAfter(inicio))
                                                        || (a.getPalestra().getInicio().isBefore(fim)
                                                        && a.getPalestra().getFim().isAfter(fim))
                                                        || (inicio.isBefore(a.getPalestra().getInicio())
                                                        && fim.isAfter(a.getPalestra().getInicio()))
                                                        || (inicio.isBefore(a.getPalestra().getFim())
                                                        && fim.isAfter(a.getPalestra().getFim())))
                                                .collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
                                            Alocacao alocacao = new Alocacao(local, palestra);
                                            alocacoes.add(alocacao);
                                            System.out.println("\nRelação criada com sucesso\n");
                                            break;
                                        } else {
                                            System.out.println("Conflito com horários");
                                        }
                                    } else if (index_local == -1) {
                                        break;
                                    } else {
                                        System.out.println("Valor inválido, insira novamente");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Sem locais adicionados");
                                break;
                            }
                        } else if (choice == 2) {
                            break;
                        } else {
                            System.out.println("Valor inválido");
                        }
                    }

                    choice = null;
                    while (true) {
                        choice = getInteger(sc, "Adicionar palestrante a palestra ?(1 - Sim, 2 - Não): ");
                        if (choice == 1) {
                            if (!palestrantes.isEmpty()) {
                                System.out.println("Palestrantes: ");
                                for (Palestrante palestrante : palestrantes) {
                                    System.out.println("\nNúmero: " + palestrantes.indexOf(palestrante));
                                    System.out.println("Nome: " + palestrante.getNome());
                                    System.out.println("Email: " + palestrante.getEmail());
                                    System.out.println("Endereço: " + palestrante.getEndereco());
                                    System.out.println("Especialidade: " + palestrante.getEspecialidade() + "\n");
                                }
                                while (true) {
                                    Integer index_palestrante = getInteger(sc,
                                            "Insira o Número do palestrante a ser atrelado ou -1 para cancelar operação: ");
                                    if (index_palestrante >= 0 && index_palestrante < palestrantes.size()) {
                                        Palestrante palestrante = palestrantes.get(index_palestrante);
                                        Apresentacao apresentacao = new Apresentacao(palestrante, palestra);
                                        apresentacoes.add(apresentacao);
                                        System.out.println("\nRelação criada com sucesso\n");
                                        break;
                                    } else if (index_palestrante == -1) {
                                        break;
                                    } else {
                                        System.out.println("Valor inválido, insira novamente");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Sem palestrantes adicionados");
                                break;
                            }

                        } else if (choice == 2) {
                            break;
                        } else {
                            System.out.println("Valor inválido");
                        }
                    }
                    System.out.println("\nAdição feita com sucesso\n");
                    return;
                } else {
                    throw new Exception("Valor inválidos");
                }
            } else {
                throw new Exception("Valor inválido");
            }
        } else {
            throw new Exception("Horários inválidos");
        }
    }

    public void RemovePalestra(Scanner sc) throws Exception {
        if (!palestras.isEmpty()) {
            System.out.println("Palestras: ");
            for (Palestra palestra : palestras) {
                System.out.println("\nNúmero: " + palestras.indexOf(palestra));
                System.out.println("Nome: " + palestra.getNome());
                System.out.println("Descrição: " + palestra.getDescricao());
                System.out.println("Capacidade de vagas: " + palestra.getVagas());
                System.out.println("Início: " + palestra.getInicio());
                System.out.println("Fim: " + palestra.getFim());
                Apresentacao apresentacao = apresentacoes.stream().filter(a -> a.getPalestra().equals(palestra))
                        .findAny().orElse(null);
                if (apresentacao != null) {
                    System.out.println("Palestrante responsável: ");
                    System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                    System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                }
                Alocacao alocacao = alocacoes.stream().filter(a -> a.getPalestra().equals(palestra)).findAny()
                        .orElse(null);
                if (alocacao != null) {
                    System.out.println("Local da palestra: ");
                    System.out.println(alocacao.getLocal().getNome());
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_palestra = getInteger(sc,
                        "Insira o Número da palestra a ser removida ou -1 para cancelar operação: ");
                if (index_palestra >= 0 && index_palestra < palestras.size()) {
                    Palestra palestra = palestras.get(index_palestra);
                    apresentacoes.removeIf(a -> a.getPalestra().equals(palestra));
                    alocacoes.removeIf(a -> a.getPalestra().equals(palestra));
                    inscricoes.removeIf(a -> a.getPalestra().equals(palestra));
                    palestras.remove(palestra);
                    System.out.println("\nRemoção feita com sucesso\n");
                    return;
                } else if (index_palestra == -1) {
                    return;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhuma palestra cadastrada");
        }
    }

    public void EditPalestra(Scanner sc) throws Exception {
        if (!palestras.isEmpty()) {
            System.out.println("Palestras: ");
            for (Palestra palestra : palestras) {
                System.out.println("\nNúmero: " + palestras.indexOf(palestra));
                System.out.println("Nome: " + palestra.getNome());
                System.out.println("Descrição: " + palestra.getDescricao());
                System.out.println("Capacidade de vagas: " + palestra.getVagas());
                System.out.println("Início: " + palestra.getInicio());
                System.out.println("Fim: " + palestra.getFim());
                Apresentacao apresentacao = apresentacoes.stream().filter(a -> a.getPalestra().equals(palestra))
                        .findAny().orElse(null);
                if (apresentacao != null) {
                    System.out.println("Palestrante responsável: ");
                    System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                    System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                }
                Alocacao alocacao = alocacoes.stream().filter(a -> a.getPalestra().equals(palestra)).findAny()
                        .orElse(null);
                if (alocacao != null) {
                    System.out.println("Local da palestra: ");
                    System.out.println(alocacao.getLocal().getNome());
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_palestra = getInteger(sc,
                        "Insira o Número da palestra a ser editada ou -1 para cancelar operação: ");
                if (index_palestra >= 0 && index_palestra < palestras.size()) {
                    Palestra palestra = palestras.get(index_palestra);
                    Palestra palestra_de_busca = new Palestra(palestra.getNome(), palestra.getDescricao(),
                            palestra.getInicio(), palestra.getFim(), palestra.getVagas(),
                            palestra.getEmiteCertificado());

                    String tmp_data = getString(sc, "Insira a data(yyyy-MM-dd): ");
                    // HH:mm
                    String hora_inicio = getString(sc, "Insira a hora de início(HH:mm): ");
                    String hora_fim = getString(sc, "Insira a hora de finalização(HH:mm): ");
                    // yyyy-MM-ddTHH:mm
                    String tmp_LocalDateTime = tmp_data + "T" + hora_inicio;
                    LocalDateTime inicio = LocalDateTime.parse(tmp_LocalDateTime);
                    tmp_LocalDateTime = tmp_data + "T" + hora_fim;
                    LocalDateTime fim = LocalDateTime.parse(tmp_LocalDateTime);
                    if (inicio.isBefore((fim))) {
                        String Nome = getString(sc, "Insira o nome: ");
                        String Descricao = getString(sc, "Insira a Descrição: ");
                        Integer tmp_boolean = getInteger(sc, "A palestra emite certificado ?(1 - Sim, 2 - Não): ");
                        if (tmp_boolean == 1 || tmp_boolean == 2) {
                            boolean EmiteCertificado;
                            if (tmp_boolean == 1) {
                                EmiteCertificado = true;
                            } else {
                                EmiteCertificado = false;
                            }
                            palestra.setNome(Nome);
                            palestra.setDescricao(Descricao);
                            palestra.setInicio(inicio);
                            palestra.setFim(fim);
                            palestra.setEmiteCertificado(EmiteCertificado);
                            Integer choice;
                            while (true) {
                                choice = getInteger(sc, "Alterar local da palestra ?(1 - Sim, 2 - Não): ");
                                if (choice == 1) {
                                    ArrayList<Local> tmp_Locais = locais.stream().filter(a -> a.getCapacidade()>=palestra.getVagas()).collect(Collectors.toCollection(ArrayList::new));
                                    if (!tmp_Locais.isEmpty()) {
                                        System.out.println("Locais: ");
                                        for (Local local : tmp_Locais) {
                                            System.out.println("\nNúmero: " + locais.indexOf(local));
                                            System.out.println("Nome: " + local.getNome());
                                            System.out.println("Capacidade: " + local.getCapacidade());
                                            if (!local.getRecursos().isEmpty()) {
                                                System.out.println("Recursos: ");
                                                for (String obj : local.getRecursos()) {
                                                    System.out.println(obj);
                                                }
                                            }
                                            ArrayList<Alocacao> tmp_alocacoes = alocacoes.stream()
                                                    .filter(a -> a.getLocal().equals(local)
                                                            || a.getLocal().getCapacidade() >= palestra.getVagas())
                                                    .collect(Collectors.toCollection(ArrayList::new));
                                            if (!tmp_alocacoes.isEmpty()) {
                                                System.out.println("Palestras do local: ");
                                                for (Alocacao alocacao : tmp_alocacoes) {
                                                    System.out.println("Nome: " + alocacao.getPalestra().getNome());
                                                    System.out
                                                            .println("Descrição: "
                                                                    + alocacao.getPalestra().getDescricao());
                                                    System.out.println("Início: " + alocacao.getPalestra().getInicio());
                                                    System.out.println("Fim: " + alocacao.getPalestra().getFim());
                                                }
                                            } else {
                                                System.out.println("Esse local não possui eventos");
                                            }
                                            System.out.println("\n");
                                        }
                                        while (true) {
                                            Integer index_local = getInteger(sc,
                                                    "Insira o Número do local a ser atrelado ou -1 para cancelar operação: ");
                                            if (index_local >= 0 && index_local < tmp_Locais.size()) {
                                                Local local = tmp_Locais.get(index_local);
                                                ArrayList<Alocacao> tmp_alocacoes = alocacoes.stream()
                                                        .filter(a -> a.getLocal().equals(local))
                                                        .collect(Collectors.toCollection(ArrayList::new));
                                                if (tmp_alocacoes.isEmpty() || tmp_alocacoes.stream()
                                                        .filter(a -> (a.getPalestra().getInicio().isBefore(inicio)
                                                                && a.getPalestra().getFim().isAfter(inicio))
                                                                || (a.getPalestra().getInicio().isBefore(fim)
                                                                && a.getPalestra().getFim().isAfter(fim))
                                                                || (inicio.isBefore(a.getPalestra().getInicio())
                                                                && fim.isAfter(a.getPalestra().getInicio()))
                                                                || (inicio.isBefore(a.getPalestra().getFim())
                                                                && fim.isAfter(a.getPalestra().getFim())))
                                                        .collect(Collectors.toCollection(ArrayList::new)).isEmpty()) {
                                                    alocacoes.removeIf(a -> a.getPalestra().equals(palestra_de_busca));
                                                    Alocacao alocacao = new Alocacao(local, palestra);
                                                    alocacoes.add(alocacao);
                                                    System.out.println("\nRelação alterada com sucesso\n");
                                                    break;
                                                } else {
                                                    System.out.println("Conflito com horários");
                                                }
                                            } else if (index_local == -1) {
                                                break;
                                            } else {
                                                System.out.println("Valor inválido, insira novamente");
                                            }
                                        }
                                        break;
                                    } else {
                                        System.out.println("Sem locais adicionados");
                                    }
                                    break;
                                } else if (choice == 2) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido");
                                }
                            }

                            choice = null;
                            while (true) {
                                choice = getInteger(sc, "Alterar palestrante da palestra ?(1 - Sim, 2 - Não): ");
                                if (choice == 1) {
                                    if (!palestrantes.isEmpty()) {
                                        System.out.println("Palestrantes: ");
                                        for (Palestrante palestrante : palestrantes) {
                                            System.out.println("\nNúmero: " + palestrantes.indexOf(palestrante));
                                            System.out.println("Nome: " + palestrante.getNome());
                                            System.out.println("Email: " + palestrante.getEmail());
                                            System.out.println("Endereço: " + palestrante.getEndereco());
                                            System.out.println(
                                                    "Especialidade: " + palestrante.getEspecialidade() + "\n");
                                        }
                                        while (true) {
                                            Integer index_palestrante = getInteger(sc,
                                                    "Insira o Número do palestrante a ser atrelado ou -1 para cancelar operação: ");
                                            if (index_palestrante >= 0 && index_palestrante < palestrantes.size()) {
                                                Palestrante palestrante = palestrantes.get(index_palestrante);
                                                apresentacoes.removeIf(a -> a.getPalestra().equals(palestra_de_busca));
                                                Apresentacao apresentacao = new Apresentacao(palestrante, palestra);
                                                apresentacoes.add(apresentacao);
                                                System.out.println("\nRelação alterada com sucesso\n");
                                                break;
                                            } else if (index_palestrante == -1) {
                                                break;
                                            } else {
                                                System.out.println("Valor inválido, insira novamente");
                                            }
                                        }
                                        break;
                                    } else {
                                        System.out.println("Sem locais adicionados");
                                    }
                                    break;
                                } else if (choice == 2) {
                                    break;
                                } else {
                                    System.out.println("Valor inválido");
                                }
                            }
                            System.out.println("\nEdição feita com sucesso\n");
                            return;
                        } else {
                            throw new Exception("Valor inválido");
                        }
                    } else {
                        throw new Exception("Horários inválidos");
                    }
                } else if (index_palestra == -1) {
                    return;
                } else {
                    System.out.println("Valor inválido, insira novamente");
                }
            }
        } else {
            throw new Exception("Nenhuma palestra cadastrada");
        }
    }

    public void lista_presenca(Scanner sc) throws Exception {
        if (!palestras.isEmpty()) {
            System.out.println("Palestras: ");
            for (Palestra palestra : palestras) {
                System.out.println("\nNúmero: " + palestras.indexOf(palestra));
                System.out.println("Nome: " + palestra.getNome());
                System.out.println("Descrição: " + palestra.getDescricao());
                System.out.println("Capacidade de vagas: " + palestra.getVagas());
                System.out.println("Início: " + palestra.getInicio());
                System.out.println("Fim: " + palestra.getFim());
                Apresentacao apresentacao = apresentacoes.stream().filter(a -> a.getPalestra().equals(palestra))
                        .findAny().orElse(null);
                if (apresentacao != null) {
                    System.out.println("Palestrante responsável: ");
                    System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                    System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                }
                Alocacao alocacao = alocacoes.stream().filter(a -> a.getPalestra().equals(palestra)).findAny()
                        .orElse(null);
                if (alocacao != null) {
                    System.out.println("Local da palestra: ");
                    System.out.println(alocacao.getLocal().getNome());
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_palestra = getInteger(sc,
                        "Imprimir lista de presença de qual palestra ?(-1 para cancelar operação): ");
                if (index_palestra >= 0 && index_palestra < palestras.size()) {
                    ArrayList<Inscricao> tmp_inscricoes = inscricoes.stream()
                            .filter(a -> a.getPalestra().equals(palestras.get(index_palestra)))
                            .collect(Collectors.toCollection(ArrayList::new));
                    if (!tmp_inscricoes.isEmpty()) {
                        System.out.println("Inscrições da palestra: ");
                        for (Inscricao inscricao : tmp_inscricoes) {
                            System.out
                                    .println("\nCódigo do Participante: " + inscricao.getParticipante().getCodigo());
                            System.out.println("Nome: " + inscricao.getParticipante().getNome());
                            System.out.println("Email: " + inscricao.getParticipante().getEmail());
                            System.out.println("Endereço: " + inscricao.getParticipante().getEndereco() + "\n");
                        }
                    } else {
                        System.out.println("Essa palestra nao possui inscrições");
                    }
                } else if (index_palestra == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido");
                }
            }
        } else {
            throw new Exception("Nenhuma palestra cadastrada");
        }
    }

    public void lista_local_e_palestras() throws Exception {
        if (!locais.isEmpty()) {
            for (Local local : locais) {
                System.out.println("Local: ");
                System.out.println("\nNúmero: " + locais.indexOf(local));
                System.out.println("Nome: " + local.getNome());
                System.out.println("Capacidade: " + local.getCapacidade());
                if (!local.getRecursos().isEmpty()) {
                    System.out.println("Recursos: ");
                    for (String obj : local.getRecursos()) {
                        System.out.println(obj);
                    }
                }
                ArrayList<Alocacao> tmp_alocacoes = alocacoes.stream().filter(a -> a.getLocal().equals(local))
                        .collect(Collectors.toCollection(ArrayList::new));
                if (!tmp_alocacoes.isEmpty()) {
                    System.out.println("\nPalestras do local: ");
                    for (Alocacao alocacao : tmp_alocacoes) {
                        System.out.println("Nome: " + alocacao.getPalestra().getNome());
                        System.out.println("Descrição: " + alocacao.getPalestra().getDescricao());
                        System.out.println("Capacidade de vagas: " + alocacao.getPalestra().getVagas());
                        System.out.println("Início: " + alocacao.getPalestra().getInicio());
                        System.out.println("Fim: " + alocacao.getPalestra().getFim());
                        Apresentacao apresentacao = apresentacoes.stream()
                                .filter(a -> a.getPalestra().equals(alocacao.getPalestra())).findAny().orElse(null);
                        if (apresentacao != null) {
                            System.out.println("Palestrante responsável: ");
                            System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                            System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                        }
                    }
                }
                System.out.println("\n");
            }
        } else {
            throw new Exception("Nenhum local cadastrado");
        }
    }

    public void palestras_de_participante(Scanner sc) throws Exception {
        if (!participantes.isEmpty()) {
            System.out.println("Participantes: ");
            for (Participante participante : participantes) {
                System.out.println("\nNúmero: " + participantes.indexOf(participante));
                System.out.println("Código do Participante: " + participante.getCodigo());
                System.out.println("Nome: " + participante.getNome());
                System.out.println("Email: " + participante.getEmail());
                System.out.println("Endereço: " + participante.getEndereco() + "\n");
            }
            while (true) {
                Integer index_participante = getInteger(sc,
                        "Imprimir lista de palestras de qual participante ?(-1 para cancelar operação): ");
                if (index_participante >= 0 && index_participante < participantes.size()) {
                    ArrayList<Inscricao> tmp_inscricoes = inscricoes.stream()
                            .filter(a -> a.getParticipante().equals(participantes.get(index_participante)))
                            .collect(Collectors.toCollection(ArrayList::new));
                    if (!tmp_inscricoes.isEmpty()) {
                        System.out.println("Palestras: ");
                        for (Inscricao inscricao : tmp_inscricoes) {
                            System.out.println("\nNome: " + inscricao.getPalestra().getNome());
                            System.out.println("Descrição: " + inscricao.getPalestra().getDescricao());
                            System.out.println("Capacidade de vagas: " + inscricao.getPalestra().getVagas());
                            System.out.println("Início: " + inscricao.getPalestra().getInicio());
                            System.out.println("Fim: " + inscricao.getPalestra().getFim());
                            Apresentacao apresentacao = apresentacoes.stream()
                                    .filter(a -> a.getPalestra().equals(inscricao.getPalestra())).findAny()
                                    .orElse(null);
                            if (apresentacao != null) {
                                System.out.println("Palestrante responsável: ");
                                System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                                System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                            }
                            Alocacao alocacao = alocacoes.stream()
                                    .filter(a -> a.getPalestra().equals(inscricao.getPalestra())).findAny()
                                    .orElse(null);
                            if (alocacao != null) {
                                System.out.println("Local da palestra: ");
                                System.out.println(alocacao.getLocal().getNome());
                            }
                            System.out.println("\n");
                        }
                    } else {
                        System.out.println("O participante nao possui inscrições");
                    }
                } else if (index_participante == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido");
                }
            }
        } else {
            throw new Exception("Nenhum participante cadastrado");
        }
    }


    public ArrayList<Certificado> EmitirCertificados(Scanner sc) throws Exception{
        ArrayList<Palestra> palestras_com_certificados = palestras.stream().filter(a -> a.getEmiteCertificado()).collect(Collectors.toCollection(ArrayList::new));
        if (!palestras_com_certificados.isEmpty()) {
            System.out.println("Palestras: ");
            for (Palestra palestra : palestras_com_certificados) {
                System.out.println("\nNúmero: " + palestras_com_certificados.indexOf(palestra));
                System.out.println("Nome: " + palestra.getNome());
                System.out.println("Descrição: " + palestra.getDescricao());
                System.out.println("Capacidade de vagas: " + palestra.getVagas());
                System.out.println("Início: " + palestra.getInicio());
                System.out.println("Fim: " + palestra.getFim());
                Apresentacao apresentacao = apresentacoes.stream().filter(a -> a.getPalestra().equals(palestra))
                        .findAny().orElse(null);
                if (apresentacao != null) {
                    System.out.println("Palestrante responsável: ");
                    System.out.println("Nome: " + apresentacao.getPalestrante().getNome());
                    System.out.println("Email: " + apresentacao.getPalestrante().getEmail());
                }
                Alocacao alocacao = alocacoes.stream().filter(a -> a.getPalestra().equals(palestra)).findAny()
                        .orElse(null);
                if (alocacao != null) {
                    System.out.println("Local da palestra: ");
                    System.out.println(alocacao.getLocal().getNome());
                }
                System.out.println("\n");
            }
            while (true) {
                Integer index_palestra = getInteger(sc,
                        "Emitir certificados de qual palestra ?(-1 para cancelar operação): ");
                if (index_palestra >= 0 && index_palestra < palestras_com_certificados.size()) {
                    ArrayList<Inscricao> tmp_inscricoes = inscricoes.stream()
                            .filter(a -> a.getPalestra().equals(palestras_com_certificados.get(index_palestra)))
                            .collect(Collectors.toCollection(ArrayList::new));
                    if (!tmp_inscricoes.isEmpty()) {
                        String Descricao = getString(sc, "Insira a descrição do certificado");
                        ArrayList<Certificado> certificados = new ArrayList<>();
                        System.out.println("Certificados: : ");
                        for (Inscricao inscricao : tmp_inscricoes) {
                            certificados.add(new Certificado(inscricao.getPalestra(), inscricao.getParticipante(), Descricao));
                            System.out.println("\nParticipante: ");
                            System.out.println("Nome: " + inscricao.getParticipante().getNome());
                            System.out.println("Email: " + inscricao.getParticipante().getEmail());
                            System.out.println("Endereço: " + inscricao.getParticipante().getEndereco());
                            System.out.println("Palestra concluída:");
                            System.out.println("Nome: " + inscricao.getPalestra().getNome());
                            System.out.println("Descrição: " + inscricao.getPalestra().getDescricao());
                            System.out.println("Início: " + inscricao.getPalestra().getInicio());
                            System.out.println("Fim: " + inscricao.getPalestra().getFim());
                            Apresentacao apresentacao = apresentacoes.stream().filter(a -> a.getPalestra().equals(inscricao.getPalestra())).findAny().orElse(null);
                            if(apresentacao != null){
                                System.out.println("Nome do palestrante: " + apresentacao.getPalestrante().getNome());
                            }
                            System.out.println("Descrição do certificado: " + Descricao + "\n");
                        }
                        System.out.println("\nEmissão feita com sucesso\n");
                        return certificados;
                    } else {
                        System.out.println("Essa palestra nao possui inscrições");
                    }
                } else if (index_palestra == -1) {
                    break;
                } else {
                    System.out.println("Valor inválido");
                }
            }
        } else {
            throw new Exception("Nenhuma palestra com possível emissão de certificado");
        }
        return null;
    }


    public String getString(Scanner sc, String txt) {
        while (true) {
            try {
                System.out.print(txt);
                return sc.nextLine();
            } catch (Exception exception) {
                System.out.println("Erro, insira o valor novamente");
                sc.nextLine(); // Limpa o buffer caso haja um erro de entrada
            }
        }
    }

    public Integer getInteger(Scanner sc, String txt) {
        while (true) {
            try {
                System.out.print(txt);
                Integer tmp = sc.nextInt();
                sc.nextLine();
                return tmp;
            } catch (Exception exception) {
                System.out.println("Erro, insira o valor novamente");
                sc.nextLine(); // Limpa o buffer caso o usuário insira um valor não-inteiro
            }
        }
    }

}
