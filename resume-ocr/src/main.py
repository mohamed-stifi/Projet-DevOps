from dotenv import load_dotenv
from src.common.config import Config
from src.common.kafka import Kafka



def main():
    print('------ Start -------')
    load_dotenv()

    config = Config()

    print('------ End -------')
if __name__ == "__main__":
    main()