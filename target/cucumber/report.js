$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("uk/gov/ipo/fast/sampleapp/deposit.feature");
formatter.feature({
  "id": "depositing-money-in-to-a-user-account",
  "description": "",
  "name": "Depositing money in to a User account",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "depositing-money-in-to-a-user-account;depositing-money-in-to-user\u0027s-account-should-add-money-to-the-user\u0027s-current-balance",
  "description": "",
  "name": "Depositing money in to User\u0027s account should add money to the User\u0027s current balance",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "a User has no money in their account",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "£100 is deposited in to the account",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "the balance should be £100",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "DepositSteps.a_User_has_no_money_in_their_account()"
});
formatter.result({
  "duration": 209110337,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 1
    }
  ],
  "location": "DepositSteps.£_is_deposited_in_to_the_account(int)"
});
formatter.result({
  "duration": 12561506,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 23
    }
  ],
  "location": "DepositSteps.the_balance_should_be_£(int)"
});
formatter.result({
  "duration": 104273,
  "status": "passed"
});
formatter.uri("uk/gov/ipo/fast/sampleapp/form-filling.feature");
formatter.feature({
  "id": "inputting-details-into-a-form",
  "description": "",
  "name": "Inputting details into a form",
  "keyword": "Feature",
  "line": 1
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 3,
  "type": "background"
});
formatter.step({
  "name": "I have logged into the application",
  "keyword": "Given ",
  "line": 4
});
formatter.match({
  "location": "FormInputSteps.i_have_logged_into_the_application()"
});
formatter.result({
  "duration": 245911,
  "status": "passed"
});
formatter.scenario({
  "id": "inputting-details-into-a-form;input-details-using-a-data-table",
  "tags": [
    {
      "name": "@important",
      "line": 7
    },
    {
      "name": "@fast",
      "line": 7
    },
    {
      "name": "@debug",
      "line": 7
    }
  ],
  "description": "",
  "name": "Input details using a data table",
  "keyword": "Scenario",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "I have loaded form \"form9a\"",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I input the following details into the form:",
  "keyword": "When ",
  "line": 10,
  "rows": [
    {
      "cells": [
        "Field",
        "Value"
      ],
      "line": 11
    },
    {
      "cells": [
        "applicationNumber",
        "1234"
      ],
      "line": 12
    },
    {
      "cells": [
        "reference",
        "my reference"
      ],
      "line": 13
    },
    {
      "cells": [
        "citiation",
        "0"
      ],
      "line": 14
    }
  ]
});
formatter.step({
  "name": "i should be able to see \"this text\"",
  "keyword": "Then ",
  "line": 15
});
formatter.match({
  "arguments": [
    {
      "val": "form9a",
      "offset": 20
    }
  ],
  "location": "FormInputSteps.i_have_loaded_form(String)"
});
formatter.result({
  "duration": 11250304,
  "status": "passed"
});
formatter.match({
  "location": "FormInputSteps.i_input_the_following_details_into_the_form(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 11054123,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "this text",
      "offset": 25
    }
  ],
  "location": "FormInputSteps.i_should_be_able_to_see(String)"
});
formatter.result({
  "duration": 192971,
  "status": "passed"
});
formatter.background({
  "description": "",
  "name": "",
  "keyword": "Background",
  "line": 3,
  "type": "background"
});
formatter.step({
  "name": "I have logged into the application",
  "keyword": "Given ",
  "line": 4
});
formatter.match({
  "location": "FormInputSteps.i_have_logged_into_the_application()"
});
formatter.result({
  "duration": 7974193,
  "status": "passed"
});
formatter.scenario({
  "id": "inputting-details-into-a-form;using-a-doc-string",
  "description": "",
  "name": "using a doc string",
  "keyword": "Scenario",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "i have been given the following information",
  "keyword": "Given ",
  "line": 19,
  "doc_string": {
    "value": " some long text",
    "line": 20,
    "content_type": ""
  }
});
formatter.step({
  "name": "i do something",
  "keyword": "When ",
  "line": 23
});
formatter.step({
  "name": "i see something else",
  "keyword": "Then ",
  "line": 24
});
formatter.match({
  "location": "FormInputSteps.i_have_been_given_the_following_information(String)"
});
formatter.result({
  "duration": 9015107,
  "status": "passed"
});
formatter.match({
  "location": "FormInputSteps.i_do_something()"
});
formatter.result({
  "duration": 154699,
  "status": "passed"
});
formatter.match({
  "location": "FormInputSteps.i_see_something_else()"
});
formatter.result({
  "duration": 162172,
  "status": "passed"
});
});