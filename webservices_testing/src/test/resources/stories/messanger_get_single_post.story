Narrative:
In order to validate getSinglePost API
As a product owner
I want to validate the response with different data sets and get appropraite response for each scenario

Scenario: 1- Verify the response with valid data
When I call getSinglePost API
Then Verify the response contains
|UserId		|Id		|Title																		|Body																																								|
|1			|1		|sunt aut facere repellat provident occaecati excepturi optio reprehenderit	|quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto	|