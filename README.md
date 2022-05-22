# Monopoly Student Edition

Dit is de server-repo van de monopoly versie van groep 18.


## Functionality Table

|PRIORITY  |ENDPOINT                                                                                                  |Client                | Client           |Server                       | Server                       |
|--------|--------------------------------------------------------------------------------------------------------|----------------------|-----------------|-----------------------------|-----------------------------|
|        |                                                                                                        |Visualize ( HTML/CSS)|Consume API (JS)|Process request (API-Bridge)|Implement Game Rules (logic)|
|        |**General Game and API Info**                                                                               |100%                  |YES/NO           |YES/NO                       |100%                         |
|        |GET /                                                                                                   |    100%                  |     YES           |          YES                   |               100%              |
|MUSTHAVE|GET /tiles                                                                                              |        100%              |     YES            |             YES                |         100%                   |
|MUSTHAVE|GET /tiles /{tileId}                                                                                    |         100%             |            YES     |             YES                |         100%                    |
|        |GET /chance                                                                                             |      100%                |       YES          |       YES                      |             100%                |
|        |GET /community-chest                                                                                    |      100%                |      YES           |        YES                     |              100%               |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Managing Games**                                                                                          |                      |                 |                             |                             |
|        |DELETE /games                                                                                           |       100%               |       YES          |              YES               |                 95%            |
|MUSTHAVE|GET /games                                                                                              |       90%               |       YES          |                 YES            |      100%                       |
|        |Additional requirement: with filters                                                                    |                      |                 |                             |                             |
|MUSTHAVE|POST /games                                                                                             |          100%            |         YES        |         YES                    |                    100%         |
|MUSTHAVE|POST /games /{gameId} /players                                                                          |       100%               |        YES         |             YES                |                  100%           |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Info**                                                                                                   |                      |                 |                             |                             |
|        |GET /games /dummy                                                                                       |          0%            |       NO          |     NO                        |             0%                |
|MUSTHAVE|GET /games /{gameId}                                                                                    |         100%             |        YES         |            YES                 |             100%                |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Turn Management**                                                                                         |                      |                 |                             |                             |
|MUSTHAVE|POST /games /{gameId} /players /{playerName} /dice                                                      |            70%          |      YES           |                 YES            |                 70%            |
|        |With jail                                                                                               |                      |                 |                             |                             |
|MUSTHAVE|POST /games /{gameId} /players /{playerName} /bankruptcy                                                |              90%        |       YES          |                 YES            |                 80%            |
|        |Decent distribution of assets                                                                           |                      |                 |                             |                             |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Tax Management**                                                                                          |                   |                |                          |                         |
|        |POST /games /{gameId} /players /{playerName} /tax /estimate                                             |               0%           |                NO |             NO                |                 0%         |POST /games /{gameId} /players /{playerName} /tax /compute                                              |                      |                 |                             |                             |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Buying property**                                                                                        |                      |                 |                             |                             |
|MUSTHAVE|POST /games /{gameId} /players /{playerName} /properties /{propertyName}                                |        100%              |       YES          |               YES              |             100%                |
|MUSTHAVE|DELETE /games /{gameId} /players /{playerName} /properties /{propertyName}                              |             100%         |         YES        |             YES               |             100%                |
|        |With 1 bank auction                                                                                     |                      |                 |                             |                             |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Improving property**                                                                                      |                      |                 |                             |                             |
|        |POST /games /{gameId} /players /{playerName} /properties /{propertyName} /houses                        |            0%          |      NO           |                 NO            |                 20%            | 
|        |DELETE /games /{gameId} /players /{playerName} /properties /{propertyName} /houses                      |                    0%          |      NO           |                 NO            |                 20%         |
|        |POST /games /{gameId} /players /{playerName} /properties /{propertyName} /hotel                         |           0%          |      NO           |                 NO            |                 20%               |
|        |DELETE /games /{gameId} /players /{playerName} /properties /{propertyName} /hotel                       |                   0%          |      NO           |                 NO            |                 20%               |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Mortgage**                                                                                                |                      |                 |                             |                             |
|        |POST /games /{gameId} /players /{playerName} /properties /{propertyName} /mortgage                      |             0%         |        NO         |                NO             |          10%                   |
|        |DELETE /games /{gameId} /players /{playerName} /properties /{propertyName} /mortgage|                            0%         |        NO         |                NO             |          10%       |        |                                                                                                        |                      |                 |                             |                             |
|        |**Interaction with another player**                                                                         |                      |                 |                             |                             |
|MUSTHAVE|DELETE /games /{gameId} /players /{playerName} /properties /{propertyName} /visitors /{debtorName} /rent|              90%        |         YES        |               YES              |             100%                |
|        |With potential debt    |                      |                 |                             |                             |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Prison**                                                                                                  |                      |                 |                             |                             |
|        |POST /games /{gameId} /prison /{playerName} /fine                                                       |             0%         |     NO            |             NO                |               5%              |
|        |POST /games /{gameId} /prison /{playerName} /free  |            0%          |       NO          |             NO                |                5%             |
|        |                                                                                                        |                      |                 |                             |                             |
|        |**Auctions**                                                                                                |                      |                 |                             |                             |
|        |GET /games /{gameId} /bank /auctions                                                                    |         0%             |       NO          |       NO                   |           0%                  |
|        |POST /games /{gameId} /bank /auctions /{propertyName} /bid                                              |            0%          |            NO     |              NO               |                 0%            |


## Known bugs

| Bug behaviour  | How to reproduce  | Why it hasn't been fixed    |
|---|---|---|
|  No Bugs  |  So Far  | We Know  |
