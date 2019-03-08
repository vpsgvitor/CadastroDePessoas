package tst;

import java.time.LocalDate;

import br.com.vitor.dao.LogCafeDao;
import br.com.vitor.model.UltimoEscolhidoCafe;

public class test {

	public static void main(String[] args) {
		UltimoEscolhidoCafe ul = new UltimoEscolhidoCafe(2, "vitao", LocalDate.now());
		LogCafeDao dao = new LogCafeDao();
		dao.salvar(ul);
	}

}
