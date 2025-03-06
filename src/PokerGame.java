import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.*;
import java.util.*;


public class PokerGame {
        
        public static void main(String[] args) {
                PokerGame game = new PokerGame();
                game.startWebServer();
        }

        private Deck deck;
        private List<Player> players;
        private List<Card> communityCards;

        public PokerGame() {
                this.deck = new Deck();
                this.communityCards = new ArrayList<>();
                this.players = new ArrayList<>();
        }

        public void startWebServer() {

                try {
                        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
                        server.createContext("/", new RootHandler(this));
                        server.setExecutor(null);
                        System.out.println("Web server started at http://localhost:8080");
                        server.start();
                } catch (Exception e) {
                        System.err.println("Server error: " + e.getMessage());
                }

        }

        private synchronized void addPlayer(String name) {
                players.add(new Player(name));
            }
        
            private synchronized void dealCommunityCards() {
                deck.dealCard(); // Burn
                for (int i = 0; i < 3; i++) {
                    communityCards.add(deck.dealCard());
                }
        
                deck.dealCard(); // Burn
                communityCards.add(deck.dealCard());
        
                deck.dealCard(); // Burn
                communityCards.add(deck.dealCard());
            }
        
            public synchronized String getGameState() {
                StringBuilder sb = new StringBuilder();
                sb.append("<h1>Community Cards</h1>");
                sb.append("<p>").append(communityCards).append("</p>");
        
                sb.append("<h2>Players</h2>");
                for (Player player : players) {
                        sb.append("<p>").append(player.getName()).append("'s Hand: ").append(player.toString()).append("</p>");
                }
                return sb.toString();
        }
        

        static class RootHandler implements HttpHandler {
                private PokerGame game;
        
                public RootHandler(PokerGame game) {
                    this.game = game;
                }
        
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    String response = "<html><head><title>Poker Game</title></head><body>";
        
                    if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                        InputStream inputStream = exchange.getRequestBody();
                        String name = new BufferedReader(new InputStreamReader(inputStream)).readLine();
                        game.addPlayer(name);
                        game.dealCommunityCards();
                    }
        
                    response += game.getGameState();
                    response += "<form method='POST'><label>Enter Player Name: </label><input type='text' name='name'/><button type='submit'>Join</button></form>";
                    response += "</body></html>";
        
                    exchange.sendResponseHeaders(200, response.length());
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
        }
        
}




