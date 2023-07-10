provider “aws” {
 assume_role {
 role_arn = “arn:aws:iam::667027238366:role/cross-account-role”
 } 
}
