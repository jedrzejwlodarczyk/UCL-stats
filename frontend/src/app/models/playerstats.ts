export interface PlayerStats{
    playerName: string;

    attack: AttackStats;
    attempts: AttemptsStats;
    defense: DefenseStats;
    disciplinary: DisciplinaryStats;
    goals: GoalsStats;
    key: KeyStats;
    distribution: DistributionStats;
    goalkeeping: GoalkeepingStats;
}

export interface AttackStats{
    name: string;
    assists: number;
    cornersTaken: number;
    offsides: number;
    dribbles: number;
}

export interface AttemptsStats{
    name: string;
    totalAttempts: number;
    attemptsOnTarget: number;
    attemptsOffTarget: number;
    blocked: number;
}

export interface DefenseStats{
    name: string;
    ballsRecovered: number;
    tackles: number;
    tacklesWon: number;
    tacklesLost: number;
    clearanceAttempted: number;
}

export interface DisciplinaryStats{
    name: string;
    foulsCommitted: number;
    foulsSuffered: number;
    yellowCards: number;
    redCards: number;
}

export interface GoalsStats{
    name: string;
    goals: number;
    insideArea: number;
    outsideArea: number;
    rightFoot: number;
    leftFoot: number;
    head: number;
    other: number;
    penaltiesScored: number;
}

export interface KeyStats{
    name: string;
    distanceCovered: number;
    topSpeed: number;
    minutesPlayed: number;
    matchesAppareance: number;
}

export interface DistributionStats{
    name: string;
    passingAccuracy: number;
    passesAttempted: number;
    passesCompleted: number;
    crossingAccuracy: number;
    crossesAttempted: number;
    crossesCompleted: number;
    freeKickTaken: number;
}

export interface GoalkeepingStats{
    name: string;
    saves: number;
    goalsConceded: number;
    savesOnPenalty: number;
    cleanSheets: number;
    punchesMade: number;
}