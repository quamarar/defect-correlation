terraform {
  required_version = ">= 0.15, < 2.0.0"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 4.61.0"
    }
    awscc = {
      source  = "hashicorp/awscc"
      version = ">= 0.49.0"
    }
  }
}



provider "aws" {
  region = "us-east-2"
  assume_role {
    role_arn = "arn:aws:iam::667027238366:role/cross-account-role"
  }
}
