import os

def get_env(key: str) -> str:
    value = os.getenv(key)

    if value is None:
        raise RuntimeError(f'{key} not set')

    return value

class DBConfig:
    def __init__(self):
        os.env()

class KafkaConfig:
    def __init__(self):


class MinioConfig:
    def __init__(self):


class Config:
    def __init__(self):

