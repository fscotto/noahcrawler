package it.noah.crawler.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.noah.crawler.enums.CrawlerEnum;
import it.noah.crawler.exception.NoahCrawlerException;
import it.noah.crawler.factory.NoahCrawlerFactory;

/**
 * Servlet implementation class NoahCrawlerServlet
 */
@WebServlet("/noahCrawling")
public class NoahCrawlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger log = LoggerFactory
			.getLogger(NoahCrawlerServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoahCrawlerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String param = request.getParameter("job");
		PrintWriter out = response.getWriter();

		try {
			if (param == null) {
				log.warn("WARNING!!! All crawler started!");
				runAllCrawler();
			}

			if (CrawlerEnum.DISTRICT_CRAWLER.name().equalsIgnoreCase(param)) {
				runCrawler(CrawlerEnum.DISTRICT_CRAWLER);
				out.println("<h1>Successful Job!!!</h1>");
			} else if (CrawlerEnum.TOWN_CRAWLER.name()
					.equalsIgnoreCase(param)) {
				runCrawler(CrawlerEnum.TOWN_CRAWLER);
				out.println("<h1>Successful Job!!!</h1>");
			} else if ("allCrawler".equalsIgnoreCase(param)) {
				runAllCrawler();
				out.println("<h1>Successful Job!!!</h1>");
			} else {
				out.println("<h1>Error 500 parameter not valid</h1>");
			}
		} catch (NoahCrawlerException | IOException e) {
			log.error("[ERROR] " + e.getMessage());
			out.println("[ERROR] " + e.getMessage());
		}
	}

	private void runAllCrawler() throws NoahCrawlerException, IOException {
		for (CrawlerEnum crawlerEnum : CrawlerEnum.values()) {
			runCrawler(crawlerEnum);
		}
	}

	private void runCrawler(CrawlerEnum crawlerEnum)
			throws NoahCrawlerException, IOException {
		NoahCrawlerFactory.getInstance(crawlerEnum).run();
	}

}
