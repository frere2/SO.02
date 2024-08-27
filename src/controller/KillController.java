package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KillController {

    private String os() {
        return System.getProperty("os.name").toLowerCase();
    }

    public void list() {
        String comando = null;
        if (os().contains("windows")) {
            comando = "tasklist";
        } else if ( os().contains("linux")) {
            comando = "ps -aux";
        }

        try {
            Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void killPid(int pid) {
        String comando = null;
        if (os().contains("windows")) {
            comando = "taskkill /PID " + pid;
        } else if (os().contains("linux")) {
            comando = "kill -9 " + pid;
        }

        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo com PID " + pid + " finalizado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void killNome(String nomeProcesso) {
        String comando = null;
        if (os().contains("windows")) {
            comando = "taskkill /IM " + nomeProcesso + ".exe";
        } else if (os().contains("linux")) {
            comando = "pkill -f " + nomeProcesso;
        }

        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo com o nome " + nomeProcesso + " finalizado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
