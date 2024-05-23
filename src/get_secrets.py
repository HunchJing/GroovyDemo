# Use this code snippet in your app.
# If you need more information about configurations
# or implementing the sample code, visit the AWS docs:
# https://aws.amazon.com/developer/language/python/

import json
import os
import org.jfrog.build.api.Module
# import boto3
# from botocore.exceptions import ClientError
# from dotenv import load_dotenv

# load_dotenv()
# aws_access_key_id = os.getenv('AWS_ACCESS_KEY_ID')
# aws_secret_access_key = os.getenv('AWS_SECRET_ACCESS_KEY')
# aws_session_token = os.getenv('AWS_SESSION_TOKEN')
region_name = os.getenv('REGION_NAME')

# session = boto3.Session(
#     aws_access_key_id=aws_access_key_id,
#     aws_secret_access_key=aws_secret_access_key,
#     aws_session_token=aws_session_token,
#     region_name=region_name)
#
# bedrock_client = session.client('bedrock-runtime')
# s3_client = session.client('s3')


# def get_secret():
#
#     secret_name = "prod/liujing/test"
#     region_name = "us-east-1"
#
#     # Create a Secrets Manager client
#     session = boto3.Session(
#         # aws_access_key_id=aws_access_key_id,
#         # aws_secret_access_key=aws_secret_access_key,
#         # aws_session_token=aws_session_token,
#         region_name=region_name
#     )
#     client = session.client(
#         service_name='secretsmanager',
#         region_name=region_name
#     )
#
#     try:
#         get_secret_value_response = client.get_secret_value(
#             SecretId=secret_name
#         )
#     except ClientError as e:
#         # For a list of exceptions thrown, see
#         # https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
#         raise e
#
#     secret = get_secret_value_response['SecretString']
#     print(secret)


def get_secret_with_cli_mode():
    secret_name = os.getenv('SECRET_NAME')
    region_name = os.getenv('REGION_NAME')
    print(secret_name)
    print(region_name)
    secret_string = "SecretString"

    # get_secret_value_response = os.popen(f'aws secretsmanager get-secret-value --secret-id {secret_name} --region {region_name} --query {secret_string}').read()
    # secret = json.loads(get_secret_value_response)
    return secret_string


# if __name__ == '__main__':
#     get_secret_with_cli_mode()