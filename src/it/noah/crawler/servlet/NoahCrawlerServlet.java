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
				log.warn("ATTENZIONE!!! Stanno partendo tutti i crawler");
				runAllCrawler();
			}

			if (CrawlerEnum.PROVINCIA_CRAWLER.name().equalsIgnoreCase(param)) {
				runCrawler(CrawlerEnum.PROVINCIA_CRAWLER);
			} else if (CrawlerEnum.COMUNE_CRAWLER.name()
					.equalsIgnoreCase(param)) {
				runCrawler(CrawlerEnum.COMUNE_CRAWLER);
			} else if ("allCrawler".equalsIgnoreCase(param)) {
				runAllCrawler();
			}
		} catch (NoahCrawlerException | IOException e) {
			log.error("[ERRORE] " + e.getMessage());
			out.println("[ERRORE] " + e.getMessage());
		}

		out.println("<h1>Job eseguito con successo!!!</h1>");
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
