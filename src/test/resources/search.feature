Feature: GitHub Repository Search and Navigation

  Scenario Outline: User visits the Github site as a guest, search for a Repository and navigate to the About page
    Given User visited the Github site
    When User search with "<repoName>"
    Then User verify with "<repoExpectName>"
    When User click the About button in the landing page footer
    Then  User verify the About page
    Examples:
      | repoName         | repoExpectName            |
      | create-react-app | facebook/create-react-app |