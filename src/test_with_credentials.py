import argparse
import os
from get_secrets import get_secret_with_cli_mode

aws_access_key_id = os.getenv('AWS_ACCESS_KEY_ID')
aws_secret_access_key = os.getenv('AWS_SECRET_ACCESS_KEY')


def main(args):
    print("aws_access_key_id: ", aws_access_key_id)
    print("aws_secret_access_key: ", aws_secret_access_key)
    if args.get_secret:
        secret = get_secret_with_cli_mode()
        print(secret)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('--get_secret', type=bool, default=False)

    parsed_args = parser.parse_args()

    main(parsed_args)